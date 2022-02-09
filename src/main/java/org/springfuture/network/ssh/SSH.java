package org.springfuture.network.ssh;

import com.jcraft.jsch.ChannelShell;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.springfuture.network.ssh.exception.ChannelClosedException;
import org.springfuture.network.ssh.exception.ConnectionException;
import org.springfuture.network.ssh.exception.ExpectTimeoutException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SSH {

    private Session session;
    private ChannelShell channelShell;
    private final String username;
    private final String password;
    private final String host;
    private InputStream in;
    private OutputStream os;
    private final StringBuilder outputBacklog = new StringBuilder();

    private final static int CONNECTION_TIMEOUT = 10000;

    public SSH(String username, String password, String host) {
        this.username = username;
        this.password = password;
        this.host = host;
    }

    public void connect() throws ConnectionException {
        JSch jsch = new JSch();
        try {
            this.session = jsch.getSession(this.username, this.host);
            this.session.setPassword(this.password);
            this.session.setServerAliveCountMax(0);
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            this.session.setConfig(config);
            this.session.connect(CONNECTION_TIMEOUT);
            channelShell = (ChannelShell) session.openChannel("shell");
            in = channelShell.getInputStream();
            channelShell.setPty(true);
            channelShell.connect();
            os = channelShell.getOutputStream();
        }catch (Exception e){
            throw new ConnectionException(e);
        }
    }

    public void send(String cmd) throws IOException{
        os.write((cmd).getBytes());
        os.flush();
        try{
            Thread.sleep(100);
        }catch (InterruptedException e) {}
    }

    public void close(){
        session.disconnect();
    }

    public ExpectResult expect(List<String> regex, int timeout) throws ChannelClosedException, ExpectTimeoutException, InterruptedException {
        byte[] tmp = new byte[1024];
        List<Pattern> patterns = regex.stream().map(Pattern::compile).collect(Collectors.toList());
        int timeoutCount = timeout >= 0? timeout * 10 : 10;
        try {
            while (true) {
                while (in.available() > 0) {
                    int i = in.read(tmp, 0, 1024);
                    if (i < 0) break;
                    outputBacklog.append(new String(tmp, 0, i));
                }
                if (channelShell.isClosed()) {
                    if (in.available() > 0) continue;
                    throw new ChannelClosedException();
                }
                if (outputBacklog.length() > 0) {
                    Matcher matcher;
                    Pattern pattern;
                    for(int i=0; i<patterns.size(); i++){
                        pattern = patterns.get(i);
                        matcher = pattern.matcher(outputBacklog.toString());
                        if (matcher.find()) {
                            int start = matcher.start();
                            int end = matcher.end();
                            ExpectResult expectResult = new ExpectResult(true, i, outputBacklog.substring(start, end), outputBacklog.substring(0, end));
                            outputBacklog.delete(0, end);
                            return expectResult;
                        }
                    }

                }
                Thread.sleep(100);
                if (--timeoutCount < 0) throw new ExpectTimeoutException("Can't expect prompts: " + regex +
                        ", backlog is: " + outputBacklog);
            }
        }catch (IOException e){
            throw new ChannelClosedException("Channel IO Exception", e);
        }
    }

    public String getOutputBacklog(){
        return outputBacklog.toString();
    }
}
