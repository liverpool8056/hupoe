package org.springfuture.network.command.swCommand.processor;

import org.springfuture.network.device.SwitchDevice;

import java.util.regex.Pattern;

public class NexusArpProcessor extends BasicArpProcessor {

    private final static Pattern p =
            Pattern.compile("(?<ip>\\d+\\.\\d+\\.\\d+\\.\\d+)\\s+\\S+\\s+(?<mac>[a-zA-Z0-9]{4}\\.[a-zA-Z0-9]{4}\\.[a-zA-Z0-9]{4})\\s+(?<port>[a-zA-Z0-9]+)");

    public NexusArpProcessor(SwitchDevice device) {
        super(device, p);
    }

    public NexusArpProcessor() {
        super(p);
    }

//    @Override
//    public Arp generate(String src) {
//        Matcher matcher = p.matcher(src);
//        if (!matcher.find()) return null;
//        String ip = matcher.group("ip");
//        String mac = matcher.group("mac");
//        mac = MacUtils.macFormatter(mac);
//        String port = matcher.group("port");
//        return new Arp(ip, mac, device.getName(), port);
//    }
}
