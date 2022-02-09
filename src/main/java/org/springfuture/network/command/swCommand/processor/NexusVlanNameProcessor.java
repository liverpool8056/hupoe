package org.springfuture.network.command.swCommand.processor;

import org.springfuture.network.bean.L2Vlan;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NexusVlanNameProcessor implements Processor<L2Vlan>{

    private final static Pattern p =
            Pattern.compile("^(?<vlanNum>\\d+)\\s+(?<vlanName>\\S+)\\s+\\S+");

    @Override
    public L2Vlan generate(String src) {
        // prompt : show vlan
        Matcher matcher = p.matcher(src);
        if(!matcher.find()) return null;
        int vlanNum = Integer.valueOf(matcher.group("vlanNum"));
        String vlanName = matcher.group("vlanName");
        return new L2Vlan(vlanName, vlanNum);
    }
}
