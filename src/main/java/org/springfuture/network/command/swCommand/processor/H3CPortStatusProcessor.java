package org.springfuture.network.command.swCommand.processor;

import org.springfuture.network.bean.PortStatus;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class H3CPortStatusProcessor implements Processor<PortStatus>{

    private final static Pattern p =
            Pattern.compile("(?<port>"+H3C_PORT_PATTERN+")\\s+" +
                    "(?<status>"+H3C_PORT_CONNECT_STATUS+")\\s+" +
                    "(?<speed>"+H3C_PORT_SPEED+")\\s+" +
                    "(?<duplex>"+H3C_PORT_DUPLEX+")\\s+" +
                    "(?<type>"+H3C_PORT_TYPE+")\\s+" +
                    "(?<vlan>\\d+|--)\\s?" +
                    "(?<desc>\\S+)?"
            );
//            Pattern.compile("(?<port>"+H3C_PORT_PATTERN+")\\s+" +
//                    "(?<status>"+H3C_PORT_CONNECT_STATUS+")\\s+" +
//                    "(?<speed>"+H3C_PORT_SPEED+")\\s+" +
//                    "(?<duplex>"+H3C_PORT_DUPLEX+")\\s+" +
//                    "(?<type>"+H3C_PORT_TYPE+")\\s+" +
//                    "(?<vlan>\\d+|--)\\s?" +
//                    "(?<desc>\\S+)?"
//            );

    @Override
    public PortStatus generate(String src) {
        Matcher matcher = p.matcher(src);
        if(!matcher.find()) return null;
        String port = matcher.group("port");
        String status = matcher.group("status");
        String speed = matcher.group("speed");
        String duplex = matcher.group("duplex");
        String type = matcher.group("type");
        String vlan = matcher.group("vlan");
        String desc = matcher.group("desc");

//        String speed = "";
//        String duplex = "";
//        String type = "";
//        String vlan = "";
//        String desc = "";
        return new PortStatus(port, desc, status, vlan, duplex, speed, type);
    }
}
