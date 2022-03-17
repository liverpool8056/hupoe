package org.springfuture.network.command.swCommand.processor;

import org.springfuture.network.bean.Arp;
import org.springfuture.network.device.SwitchDevice;
import org.springfuture.network.utils.NetUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasicArpProcessor extends AbstractProcessor<Arp>{

    private final Pattern p;

    public BasicArpProcessor(SwitchDevice switchDevice, Pattern p) {
        super(switchDevice);
        this.p = p;
    }

    public BasicArpProcessor(Pattern p){
        super();
        this.p = p;
    }

    @Override
    public Arp generate(String src) {
        Matcher matcher = p.matcher(src);
        if (!matcher.find()) return null;
        String ip = matcher.group("ip");
        String mac = matcher.group("mac");
        mac = NetUtils.macFormatter(mac);
//        String vlanNum = matcher.group("vlanNum");
        String port = matcher.group("port");
        return new Arp(ip, mac, device.getIp(), port);
    }
}
