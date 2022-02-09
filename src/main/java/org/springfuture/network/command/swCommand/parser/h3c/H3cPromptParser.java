package org.springfuture.network.command.swCommand.parser.h3c;

import org.springfuture.network.bean.Arp;
import org.springfuture.network.bean.MacEntry;
import org.springfuture.network.bean.Port;
import org.springfuture.network.command.swCommand.parser.BasePromptParser;
import org.springfuture.network.utils.MacUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class H3cPromptParser extends BasePromptParser {

    protected final static String H3C_ERROR_PROMPT = "Unrecognized command found";

    @Override
    public Boolean error(String prompt) {
        return super.parseError(prompt, H3C_ERROR_PROMPT);
    }

    @Override
    public List<Arp> parseArpList(String prompt) {
        ArrayList<Arp> arps = new ArrayList<>(32);
        String[] lines = prompt.split("\n");
        String pattern = "(\\d+\\.\\d+\\.\\d+\\.\\d+)\\s+([a-zA-Z0-9]{4}-[a-zA-Z0-9]{4}-[a-zA-Z0-9]{4})\\s+([\\d-]+)\\s+([A-Z0-9/]+)";
        Pattern compile = Pattern.compile(pattern);
        for(String line : lines){
            Matcher matcher = compile.matcher(line);
            if (matcher.find()){
                String ip = matcher.group(1);
                String mac = matcher.group(2);
                mac = MacUtils.macFormatter(mac);
                String vlanNum = matcher.group(3);
                String port = matcher.group(4);
//                if(vlanNum.equals("--")) {
//                    arp.setPort(port);
//                }else{
//                    arp.setPort("Vlan"+vlanNum);
//                }
                Arp arp = new Arp(ip, mac, "", port);
                arps.add(arp);
            }
        }
        return arps;
    }

    @Override
    public List<MacEntry> parseMacTable(String prompt) {
        ArrayList<MacEntry> macEntries = new ArrayList<>();
        String pattern = "([a-z0-9]{4}-[a-z0-9]{4}-[a-z0-9]{4})\\s+(\\d+)\\s+Learned\\s+([A-Za-z0-9/]+)";
        Pattern compile = Pattern.compile(pattern);
        for(String line: prompt.split("\n")){
            Matcher matcher = compile.matcher(line);
            if(matcher.find()){
                String mac = matcher.group(1);
                String vlanNum = matcher.group(2);
                String port = matcher.group(3);
                MacEntry macEntry = new MacEntry(MacUtils.macFormatter(mac), vlanNum, "", port);
                macEntries.add(macEntry);
            }
        }
        return macEntries;
    }

    @Override
    public HashMap<Integer, String> parseVlanNameMap(String prompt) {
        // prompt : disp vlan brief
        // vlanMap : { 1 : "vlan description" }
        int vlanNumStartColNum = 0;
        int vlanNameStartColNum = 10;
        int portStartColNum = 43;
        String pattern = "^\\d";
        final Pattern r = Pattern.compile(pattern);
        HashMap<Integer, String> vlanNameMap = new HashMap<>();
        String[] lines = prompt.split("\n");
        for (String line : lines) {
            Matcher matcher = r.matcher(line);
            if(matcher.find()){
                String vlanNum = line.substring(vlanNumStartColNum, vlanNameStartColNum).trim();
                String vlanName = line.substring(vlanNameStartColNum, portStartColNum).trim();
                vlanNameMap.put(Integer.valueOf(vlanNum), vlanName);
            }
        }
        return vlanNameMap;
    }

    @Override
    public HashMap<String, String> parseVlanDetail(String prompt) {
        //prompt : disp ip inter vlan %s(vlanId)
        //map: {"subnet": "192.168.2.0", "mask": "255.255.255.0"}
        HashMap<String, String> vlanDetail = new HashMap<>();
        String[] lines = prompt.split("\n");
        for(String line: lines){
            int idx = line.indexOf("Internet Address is ");
            if(idx>=0){
                idx = idx + 20;
                String subnetStr = line.substring(idx).trim().split(" ")[0];
//                log.info("subnetstr is: {}", subnetStr);
                String[] subnetSegs = subnetStr.split("/");
                vlanDetail.put("segment", subnetSegs[0]);
                vlanDetail.put("mask", maskMap.get(Integer.valueOf(subnetSegs[1])));
                break;
            }
        }
        return vlanDetail;
    }

    @Override
    public List<HashMap<String, String>> parseVlanInterfaceBrief(String prompt) {
        // prompt : disp ip int b
        // vlanMap : {vlanNum: "10", description: ""}
        String pattern = "\\D+(\\d+)";
        Pattern compile = Pattern.compile(pattern);
        ArrayList<HashMap<String, String>> hashMaps = new ArrayList<>();

        String[] lines = prompt.split("\n");
        for(String line: lines){
            if(!line.toUpperCase(Locale.ROOT).startsWith("VLAN")) continue;
            StringTokenizer stringTokenizer = new StringTokenizer(line);
            String interfaceName = stringTokenizer.nextToken();
            Matcher matcher = compile.matcher(interfaceName);
            if (matcher.find()){
                HashMap<String, String> hashMap = new HashMap<>();
                String vlanNums = matcher.group(1);
                String physicalStatus = stringTokenizer.nextToken();
                String protocolStatus = stringTokenizer.nextToken();
                String ipAddr = stringTokenizer.nextToken();
                String vpnInstance = stringTokenizer.nextToken();
                String description = stringTokenizer.nextToken();
                description = description.startsWith("--")? "" : description;
                hashMap.put("vlanNum", vlanNums);
                hashMap.put("physicalStatus", physicalStatus);
                hashMap.put("protocolStatus", protocolStatus);
                hashMap.put("ip", ipAddr);
                hashMap.put("description", description);
                hashMaps.add(hashMap);
            }
        }
        return hashMaps;
    }

    @Override
    public List<Integer> parsePortGroupNums(String prompt) {
        ArrayList<Integer> portGroupNums = new ArrayList<>();
        String pattern = "^BAGG(\\d+)\\s+";
        final Pattern r = Pattern.compile(pattern);

        String[] lines = prompt.split("\n");
        for (String line: lines) {
            Matcher matcher = r.matcher(line);
            if(matcher.find()){
                String portGroupNum = matcher.group(1);
                portGroupNums.add(Integer.valueOf(portGroupNum));
            }
        }
        return portGroupNums;
    }

    @Override
    public List<Port> parseGetPortStatus(String prompt) {
        System.out.println("----------------prompt is: " + prompt);
        ArrayList<String> l3PortList = new ArrayList<>();
        ArrayList<String> l2PortList = new ArrayList<>();
        ArrayList<Port> ports = new ArrayList<>();
        int Interface = 0;
        boolean put = false;
        for(String line: prompt.split("\n")){
            if(line.startsWith("Interface")) {
                Interface++;
                put = true;
                continue;
            }
            String lineWithNoSlashR = line.replace("\r", ""); // no \r
            if(null == lineWithNoSlashR || lineWithNoSlashR.length() == 0) {
                put = false;
                continue;
            }
            if(Interface==1 && put){
                if(lineWithNoSlashR.length()!=0)  l3PortList.add(line);
            }else if(Interface==2 && put){
                if(lineWithNoSlashR.length()!=0)  l2PortList.add(line);
            }

        }
        for(String l3Port : l3PortList){
            StringTokenizer stringTokenizer = new StringTokenizer(l3Port);
            String name = stringTokenizer.nextToken();
            String link = stringTokenizer.hasMoreTokens() ? stringTokenizer.nextToken() : "";
            String protocol = stringTokenizer.hasMoreTokens() ? stringTokenizer.nextToken() : "";
            String status;
            if(link.startsWith("DOWN")){
                status = "DOWN";
            }else if(protocol.startsWith("UP")){
                status = "UP";
            } else status = "DONW";
            String primaryIP = stringTokenizer.hasMoreTokens() ? stringTokenizer.nextToken() : null;
            String description = stringTokenizer.hasMoreTokens() ? stringTokenizer.nextToken() : "";
//            Port port = new Port();
//            port.setName(name);
//            port.setDescription(description);
//            port.setStatus(status);
//            port.setVlan("routed");
//            port.setDuplex("auto");
//            port.setSpeed("auto");
//            ports.add(port);
        }
        for(String l2Port : l2PortList){
            StringTokenizer stringTokenizer = new StringTokenizer(l2Port);
            String name = stringTokenizer.nextToken();
            String status = stringTokenizer.nextToken();
            String speed = stringTokenizer.nextToken();
            String duplex = stringTokenizer.nextToken();
//            String type = stringTokenizer.nextToken();
            String vlan = stringTokenizer.nextToken();
            String description = stringTokenizer.hasMoreTokens() ? stringTokenizer.nextToken() : "";
//            Port port = new Port();
//            port.setName(name);
//            port.setDescription(description);
//            port.setVlan(vlan);
//            port.setDuplex(duplex);
//            port.setStatus(status);
//            port.setSpeed(speed);
//            ports.add(port);
        }
        return ports;
    }
}
