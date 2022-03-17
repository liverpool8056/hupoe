package org.springfuture.network.command.swCommand.processor;

import org.springfuture.network.bean.MacEntry;
import org.springfuture.network.device.SwitchDevice;
import org.springfuture.network.utils.NetUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasicMacTableProcessor extends AbstractProcessor<MacEntry>{

    private final Pattern p;

    public BasicMacTableProcessor(SwitchDevice device, Pattern p) {
        super(device);
        this.p = p;
    }

    public BasicMacTableProcessor(Pattern p) {
        this.p = p;
    }

    @Override
    public MacEntry generate(String src) {
        Matcher matcher = p.matcher(src);
        if(!matcher.find()) return null;
        String mac = matcher.group("mac");
        String vlanNum = matcher.group("vlanNum");
        String port = matcher.group("port");
        return new MacEntry(NetUtils.macFormatter(mac), vlanNum, device.getIp(), port);
    }

}
