package org.springfuture.network.command.swCommand.processor;

import org.springfuture.network.bean.Arp;
import org.springfuture.network.device.SwitchDevice;
import org.springfuture.network.utils.MacUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class H3CArpProcessor extends BasicArpProcessor{

    private final static Pattern p =
            Pattern.compile("(?<ip>"+IP_PATTERN+")\\s+" +
                    "(?<mac>"+MAC_4_LOWER_SLASH_PATTERN+")\\s+(?<vlanNum>[\\d-]+)\\s+(?<port>"+H3C_PORT_PATTERN+")");

    public H3CArpProcessor(SwitchDevice switchDevice) {
        super(switchDevice, p);
    }

    public H3CArpProcessor() {
        super(p);
    }

//    @Override
//    public Arp generate(String src) {
//        Matcher matcher = p.matcher(src);
//        if (!matcher.find()) return null;
//        String ip = matcher.group("ip");
//        String mac = matcher.group("mac");
//        mac = MacUtils.macFormatter(mac);
////        String vlanNum = matcher.group("vlanNum");
//        String port = matcher.group("port");
//        return new Arp(ip, mac, device.getName(), port);
//    }
}
