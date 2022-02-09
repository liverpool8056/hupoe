package org.springfuture.network.command.swCommand.parser;

import org.springfuture.network.bean.Arp;
import org.springfuture.network.bean.MacEntry;
import org.springfuture.network.bean.Port;
import org.springfuture.network.utils.MacUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasePromptParser implements PromptParser{

    protected final static HashMap<Integer, String> maskMap = new HashMap<>();
    protected final static String CISCO_ERROR_PROMPT = "% Invalid";


    static {
        maskMap.put(32, "255.255.255.255");     //1
        maskMap.put(31, "255.255.255.254");     //2
        maskMap.put(30, "255.255.255.252");     //4
        maskMap.put(29, "255.255.255.248");     //8
        maskMap.put(28, "255.255.255.240");     //16
        maskMap.put(27, "255.255.255.224");     //32
        maskMap.put(26, "255.255.255.192");     //64
        maskMap.put(25, "255.255.255.128");     //128
        maskMap.put(24, "255.255.255.0");       //256
        maskMap.put(23, "255.255.254.0");       //2
        maskMap.put(22, "255.255.252.0");       //4
        maskMap.put(21, "255.255.248.0");       //8
        maskMap.put(20, "255.255.240.0");       //16
        maskMap.put(19, "255.255.224.0");       //32
        maskMap.put(18, "255.255.192.0");       //64
        maskMap.put(17, "255.255.128.0");       //128
        maskMap.put(16, "255.255.0.0");         //256
    }

    @Override
    public Boolean error(String prompt) {
        return parseError(prompt, CISCO_ERROR_PROMPT);
    }

    protected Boolean parseError(String prompt, String errorPrompt){
        return prompt.contains(errorPrompt);
    }

    @Override
    public List<Arp> parseArpList(String prompt) {
        ArrayList<Arp> arps = new ArrayList<>();
        String[] lines = prompt.split("\n");
        String pattern = "(\\d+\\.\\d+\\.\\d+\\.\\d+)\\s+\\S+\\s+([a-zA-Z0-9]{4}\\.[a-zA-Z0-9]{4}\\.[a-zA-Z0-9]{4})\\s+([a-zA-Z0-9]+)";
        Pattern compile = Pattern.compile(pattern);
        for(String line : lines){
            Matcher matcher = compile.matcher(line);
            if (matcher.find()){
                String ip = matcher.group(1);
                String mac = matcher.group(2);
                String port = matcher.group(3);
                Arp arp = new Arp(ip, mac, "", port);
                arps.add(arp);
            }
        }
        return arps;
    }

    @Override
    public List<MacEntry> parseMacTable(String prompt) {
        ArrayList<MacEntry> macEntries = new ArrayList<>();
        String pattern = "(\\d+)\\s+([a-z0-9]{4}\\.[a-z0-9]{4}\\.[a-z0-9]{4})\\s+(dynamic|static)\\s+[\\d-]+\\s+[TF]\\s+[TF]\\s+([A-Za-z0-9-()/]+)";
        Pattern compile = Pattern.compile(pattern);
        for(String line: prompt.split("\n")){
            Matcher matcher = compile.matcher(line);
            if(matcher.find()){
                String vlanNum = matcher.group(1);
                String mac = matcher.group(2);
//                String macType = matcher.group(3); //dynamic or static
                String port = matcher.group(4); //
                MacEntry macEntry = new MacEntry(MacUtils.macFormatter(mac), vlanNum, "", port);
                macEntries.add(macEntry);
            }
        }
        return macEntries;
    }

    @Override
    public String interfaceConfig(String prompt){
        String[] lines = prompt.split("\n");
        List<String> buffer = new ArrayList<>();
        for(int n= lines.length-1; n >= 0; n--){
            String line = lines[n];
//            if( blankLine(line) || unusefulLine(line) ) continue;
            buffer.add(line.trim());
            if(line.startsWith("interface")) break;
        }
        Collections.reverse(buffer);
        return String.join(";", buffer);
    }

    @Override
    public HashMap<Integer, String> parseVlanNameMap(String prompt){
        // prompt : show vlan
        // vlanMap : { 1 : "vlan description" }
        HashMap<Integer, String> vlanNameMap = new HashMap<>();
        String[] lines = prompt.split("\n");
        for (String line : lines) {
            if(!line.contains("active") || line.startsWith("Inactive")) continue;
            StringTokenizer pas = new StringTokenizer(line," ");
            String vlanNum = pas.nextToken();
            String description = pas.nextToken();

            vlanNameMap.put(Integer.valueOf(vlanNum), description);
        }
        return vlanNameMap;
    }

    @Override
    public HashMap<String, String> parseVlanDetail(String prompt){
        //prompt : show ip inter vlan %s(vlanId)
        //map: {"subnet": "192.168.2.0", "mask": "255.255.255.0"}
        HashMap<String, String> vlanDetail = new HashMap<>();
        String[] lines = prompt.split("\n");
        for(String line: lines){
            int idx = line.indexOf("IP subnet:");
            if(idx>0){
                idx = idx + 10;
                String subnetStr = line.substring(idx).trim();
//                log.info("subnetstr is: {}", subnetStr);
                String[] subnetSegs = subnetStr.split("/");
                idx = subnetSegs[1].indexOf(" ");
                if(idx > 0) subnetSegs[1] = subnetSegs[1].substring(0, idx);
                vlanDetail.put("segment", subnetSegs[0]);
                vlanDetail.put("mask", maskMap.get(Integer.valueOf(subnetSegs[1])));
                break;
            }
        }
        return vlanDetail;
    }

    @Override
    public List<HashMap<String, String>> parseVlanInterfaceBrief(String prompt){
        // prompt : show ip int b
        // vlanMap : {}
        ArrayList<HashMap<String, String>> hashMaps = new ArrayList<>();

        String pattern = "^Vlan(\\d+)\\s+(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})\\s+protocol";
        final Pattern r = Pattern.compile(pattern);

        String[] lines = prompt.split("\n");

        for (String line: lines) {
            Matcher matcher = r.matcher(line);
            if(matcher.find()){
                HashMap<String, String> hashMap = new HashMap<>();
                String vlanNum = matcher.group(1);
                String ipAddr = matcher.group(2);
                hashMap.put("vlanNum", vlanNum);
                hashMap.put("ipAddr", vlanNum);
                hashMaps.add(hashMap);
            }
        }
        return hashMaps;
    }

    @Override
    public List<Integer> parsePortGroupNums(String prompt) {
        ArrayList<Integer> portGroupNums = new ArrayList<>();
        String pattern = "^(\\d+)\\s+";
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
        String parseGetPortStatusPatternString = "([PVE][a-zA-z/0-9]+)\\s+(\\S+)\\s+([A-Za-z]+)\\s+([a-zA-z0-9]+)\\s+([a-zA-z0-9]+)\\s+([a-zA-z0-9]+)";
        Pattern compile = Pattern.compile(parseGetPortStatusPatternString);
        Matcher matcher = compile.matcher(prompt);
        ArrayList<Port> ports = new ArrayList<>();
        while(matcher.find()){
            if(matcher.group(1).equals("Port"))
                //ignore table header
                continue;
//            Port port = new Port();
//            port.setName(matcher.group(1));
//            port.setDescription(matcher.group(2));
//            port.setStatus(matcher.group(3));
//            port.setVlan(matcher.group(4));
//            port.setDuplex(matcher.group(5));
//            port.setSpeed(matcher.group(6));
//            ports.add(port);
        }
        return ports;
    }

    @Override
    public String parseManufacturer(String prompt) {
        if(prompt.contains("CISCO") || prompt.contains("Cisco") || prompt.contains("cisco")){
            return "cisco";
        }else{
            return "h3c";
        }
    }

    @Override
    public String parseGetMacOnPort(String prompt) {
        String pattern = "([0-9a-z]{4}\\.[0-9a-z]{4}\\.[0-9a-z]{4})";
        Pattern r = Pattern.compile(pattern);
        for (String datum : prompt.split("\n")) {
            String line = datum.replace("-", ".");
            Matcher matcher = r.matcher(line);
            if (matcher.find()) {
                return matcher.group(0);
            }
        }
        return "";
    }
}
