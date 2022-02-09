package org.springfuture.network.session;

import org.springfuture.network.bean.Facts;
import org.springfuture.network.device.SwitchDevice;
import org.springfuture.network.exception.OpenSessionException;
import org.springfuture.network.exception.SessionReadException;
import org.springfuture.network.manufacturer.Manufacturer;
import org.springfuture.network.ssh.ExpectResult;
import org.springfuture.network.ssh.SSH;
import org.springfuture.network.ssh.exception.ChannelClosedException;
import org.springfuture.network.ssh.exception.ConnectionException;
import org.springfuture.network.ssh.exception.ExpectTimeoutException;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractDevSession implements DevSession{

    protected final static List<String> DEFAULT_PROMPTS = Arrays.asList("\\S+>", "\\S#", "\\S]");
    protected final static String DEFAULT_ERROR_PATTERN = "% Invalid command";

    protected final static int DEFAULT_EXPECT_TIMEOUT = 3;

//    protected String DEFAULT_DEV_NAME_PATTERN = "([A-Z]{2}-[A-Z]+-[A-Z]{1,2}-.+-\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}.*)[>#\\]]";
    protected String DEFAULT_DEV_NAME_PATTERN = "(?<devName>\\S)[>#]]";

    protected SSH ssh;
    protected SwitchDevice switchDevice;
    protected Pattern devNamePattern = Pattern.compile(DEFAULT_DEV_NAME_PATTERN);

    public AbstractDevSession(SwitchDevice switchDevice) {
        this.switchDevice = switchDevice;
        if(switchDevice.getManufacturer()==null) this.switchDevice.setManufacturer(Manufacturer.UNKNOWN);
    }

    @Override
    public void openSession(String username, String password) throws OpenSessionException {
        ssh = new SSH(username, password, switchDevice.getIp());

        try {
            ssh.connect();
            ExpectResult expectResult = expect();
            this.switchDevice.setManufacturer(parseManufacture(expectResult.getOutput()));
        } catch (ConnectionException | SessionReadException e) {
            ssh.close();
            throw new OpenSessionException("Can't open session: " + switchDevice.getIp(), e);
        }
    }

    @Override
    public void closeSession(){
        ssh.close();
    }

    @Override
    public void close(){
        closeSession();
    }

    @Override
    public String getHostName() throws ExecutionException {
        ExpectResult expectResult = sendCmd("");
        String output = expectResult.getOutput();
        Matcher matcher = devNamePattern.matcher(output);
        return matcher.find()? matcher.group("devName") : output;
    }

    @Override
    public Facts getFacts() throws ExecutionException {
        String devName = getHostName();
        Manufacturer manufacturer = switchDevice.getManufacturer();
        Facts facts = new Facts(devName, manufacturer, "", "");
        return facts;
    }

    public ExpectResult sendCmd(String cmd) throws ExecutionException {
        return sendCmd(cmd, DEFAULT_PROMPTS, DEFAULT_EXPECT_TIMEOUT);
    }

    public ExpectResult sendCmd(String cmd, int timeout) throws ExecutionException {
        return sendCmd(cmd, DEFAULT_PROMPTS, timeout);
    }

    public ExpectResult sendCmd(String cmd, List<String> expectedPrompts) throws ExecutionException{
        return sendCmd(cmd, expectedPrompts, DEFAULT_EXPECT_TIMEOUT);
    }

    public ExpectResult sendCmd(String cmd, List<String> expectedPrompts, int timeOut) throws ExecutionException{
        ExpectResult expect;
        try {
            ssh.send(cmd+"\n");
            expect = expect(expectedPrompts, timeOut);
        } catch (IOException | SessionReadException e) {
            throw new ExecutionException(e);
        }
        if(checkValidCommand(expect.getOutput())) throw new ExecutionException("Invalid command: " + cmd + "\nOutput is: " + expect  );
        return expect;
    }

    private ExpectResult expect() throws SessionReadException {
        return expect(DEFAULT_PROMPTS, DEFAULT_EXPECT_TIMEOUT);
    }

    private ExpectResult expect(int timeout) throws SessionReadException{
        return expect(DEFAULT_PROMPTS, timeout);
    }

    private ExpectResult expect(List<String> exceptedPrompts, int timeOut) throws SessionReadException{
        try {
            ExpectResult expectResult = ssh.expect(exceptedPrompts, timeOut);
            return expectResult;
        } catch (ExpectTimeoutException e) {
            throw new SessionReadException(e);
        } catch (ChannelClosedException | InterruptedException e) {
            throw new SessionReadException(e);
        }
    }

    // get Manufacture from output when opening session
    private Manufacturer parseManufacture(String prompt){
        for(Manufacturer manufacturer : Manufacturer.values()){
            for(String alia : manufacturer.alias()){
                if(prompt.contains(alia)){
                    return manufacturer;
                }
            }
        }
        return Manufacturer.UNKNOWN;
    }

    @Override
    public Manufacturer getManufacturer() {
        return switchDevice.getManufacturer();
    }

    public void setDevNamePattern(String devNamePattern){
        this.devNamePattern = Pattern.compile(devNamePattern);
    }

    protected boolean checkValidCommand(String output){
        return output == null ? true : output.contains(DEFAULT_ERROR_PATTERN);
    }
}
