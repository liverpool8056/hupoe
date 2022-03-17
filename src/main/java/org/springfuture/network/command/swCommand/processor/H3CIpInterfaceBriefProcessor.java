package org.springfuture.network.command.swCommand.processor;

import org.springfuture.network.bean.Port;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class H3CIpInterfaceBriefProcessor implements Processor<Port>{

    private final static Pattern p =
            Pattern.compile("^(?<port>"+H3C_PORT_PATTERN+"|"+ H3C_LOOP_PORT_PATTERN +"|"+ H3C_VLAN_PORT_PATTERN+")\\s+" +
                    "(?<physical>"+H3C_PORT_PHYSICAL_STATUS+")\\s+" +
                    "(?<protocol>"+H3C_PORT_PROTOCOL_STATUS+")\\s+" +
                    "(?<ip>"+H3C_PORT_IP_PATTERN+")\\s+" +
                    "(?:--|\\S+)\\s+" +
                    "(?<desc>--|\\S+)"
            );

    @Override
    public Port generate(String src) {
        Matcher matcher = p.matcher(src);
        if(!matcher.find()) return null;
        String portName = matcher.group("port");
        String physicalStatus = matcher.group("physical");
        String adminStatus = physicalStatus.startsWith("*") ? "down" : "up";
        String protocolStatus = matcher.group("protocol");
        String ip = matcher.group("ip");
        String desc = matcher.group("desc");
        if(ip.equals("--")) ip = "";
        Port port = new Port(portName, physicalStatus, protocolStatus, adminStatus, ip, desc);
        return port;
    }
}
