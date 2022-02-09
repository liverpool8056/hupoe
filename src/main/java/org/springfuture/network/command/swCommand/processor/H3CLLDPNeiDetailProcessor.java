package org.springfuture.network.command.swCommand.processor;

import org.springfuture.network.bean.LLDPNeighbor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class H3CLLDPNeiDetailProcessor implements Processor<LLDPNeighbor>{
    private final static Pattern LOCAL_PORT_PATTERN = Pattern.compile("LLDP neighbor-information of port \\d+\\[(?<localPort>.+)\\]:$");
    private final static Pattern CHASSIS_PATTERN = Pattern.compile("Chassis ID\\s+: (?<chassisId>.+)$");
    private final static Pattern REMOTE_PORT_PATTERN = Pattern.compile("Port ID\\s+: (?<remotePort>.+)$");
    private final static Pattern REMOTE_SYSTEM_NAME = Pattern.compile("System name\\s+: (?<remoteSystemName>.+)$");
    private final static Pattern REMOTE_MANAGEMENT_ADDRESS = Pattern.compile("Management dddress\\s+: (?<managementAddress>.+)$");

    private final static Pattern SEGMENT_START_PATTERN = LOCAL_PORT_PATTERN;
    private final static Pattern SEGMENT_END_PATTERN = Pattern.compile("^$");

    private final static Pattern[] PATTERNS = {SEGMENT_START_PATTERN, CHASSIS_PATTERN, REMOTE_PORT_PATTERN,
            REMOTE_SYSTEM_NAME, REMOTE_MANAGEMENT_ADDRESS, SEGMENT_END_PATTERN};

    private boolean startFlag = false;
    private int i = 0;
    private String chassisId, remotePort, localPort, remoteSystemName, managementAddress;


    @Override
    public LLDPNeighbor generate(String src) {
        for(int i = 0; i < PATTERNS.length; i++){
            Pattern p = PATTERNS[i];
            Matcher matcher = p.matcher(src);
            if(matcher.find()){
                switch (i) {
                    case 0://start
                        startFlag = true;
                        localPort = matcher.group("localPort");
                        break;
                    case 1:
                        chassisId = matcher.group("chassisId");
                        break;
                    case 2:
                        remotePort = matcher.group("remotePort");
                        break;
                    case 3:
                        remoteSystemName = matcher.group("remoteSystemName");
                        break;
                    case 4:
                        managementAddress = matcher.group("managementAddress");
                        break;
                    case 5:
                        if (startFlag) {
                            startFlag = false;
                            i = 0;
                            return new LLDPNeighbor(localPort, chassisId, remoteSystemName, remotePort, managementAddress);
                        }
                        break;
                    default:
//                    break;
                }
                i++;
            }
        }
        return null;
    }
}
