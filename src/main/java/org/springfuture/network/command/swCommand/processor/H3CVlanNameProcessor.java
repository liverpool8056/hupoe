package org.springfuture.network.command.swCommand.processor;

import org.springfuture.network.bean.L2Vlan;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class H3CVlanNameProcessor implements Processor<L2Vlan>{

    private final static Pattern p = Pattern.compile("^\\d");
    private final static int vlanNumStartColNum = 0;
    private final static int vlanNameStartColNum = 10;
    private final static int portStartColNum = 43;

    @Override
    public L2Vlan generate(String src) {
        Matcher matcher = p.matcher(src);
        if(!matcher.find()) return null;
        int vlanNum = Integer.valueOf(src.substring(vlanNumStartColNum, vlanNameStartColNum).trim());
        String vlanName = src.substring(vlanNameStartColNum, portStartColNum).trim();
        L2Vlan l2Vlan = new L2Vlan(vlanName, vlanNum);
        return l2Vlan;
    }
}
