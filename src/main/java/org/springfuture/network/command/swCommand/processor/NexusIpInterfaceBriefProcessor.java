package org.springfuture.network.command.swCommand.processor;

import org.springfuture.network.bean.Port;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NexusIpInterfaceBriefProcessor implements Processor<Port> {

    private final static Pattern p =
            Pattern.compile("^(?<port>"+CISCO_PORT_PATTERN+"|" +CISCO_LOOP_PORT_PATTERN+"|"+CISCO_VLAN_PORT_PATTERN+")\\s+" +
                    "(?<ip>"+IP_PATTERN+")\\s+" +
                    "protocol-(?<protocol>up|down)/" +
                    "link-(?<physical>up|down)/" +
                    "admin-(?<admin>up|down)");
    @Override
    public Port generate(String src) {
        Matcher matcher = p.matcher(src);
        if(!matcher.find()) return null;
        String port = matcher.group("port");
        String ip = matcher.group("ip");
        String physicalStatus = matcher.group("physical");
        String adminStatus = matcher.group("admin");
        String protocolStatus = matcher.group("protocol");
        return new Port(port, physicalStatus, protocolStatus, adminStatus, ip, "");
    }
}
