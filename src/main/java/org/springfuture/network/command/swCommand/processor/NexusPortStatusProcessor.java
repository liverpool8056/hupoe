package org.springfuture.network.command.swCommand.processor;

import org.springfuture.network.bean.PortStatus;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NexusPortStatusProcessor implements Processor<PortStatus>{
    private final static Pattern p =
            Pattern.compile("(?<port>"+CISCO_PORT_PATTERN+")\\s+" +
                    "(?<desc>\\S+)\\s+" +
                    "(?<status>"+CISCO_PORT_CONNECT_STATUS+")\\s+" +
                    "(?<vlan>\\d+|trunk|routed)\\s+" +
                    "(?<duplex>"+CISCO_PORT_DUPLEX+")\\s+" +
                    "(?<speed>"+CISCO_PORT_SPEED+")\\s+" +
                    "(?<type>\\S+)");
    @Override
    public PortStatus generate(String src) {
        Matcher matcher = p.matcher(src);
        if(!matcher.find()) return null;
        String portName = matcher.group("port");
        String desc = matcher.group("desc");
        String status = matcher.group("status");
        String vlan = matcher.group("vlan");
        String duplex = matcher.group("duplex");
        String speed = matcher.group("speed");
        String type = matcher.group("type");
        PortStatus portStatus = new PortStatus(portName, desc, status, vlan, duplex, speed, type);
        return portStatus;
    }
}
