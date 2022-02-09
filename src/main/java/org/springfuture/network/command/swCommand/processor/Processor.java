package org.springfuture.network.command.swCommand.processor;

public interface Processor <T>{

    String IP_PATTERN = "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}";
    String MAC_4_LOWER_DOT_PATTERN = "[a-z0-9]{4}\\.[a-z0-9]{4}\\.[a-z0-9]{4}";
    String MAC_4_LOWER_SLASH_PATTERN ="[a-z0-9]{4}-[a-z0-9]{4}-[a-z0-9]{4}";
    //CISCO
    String CISCO_PORT_PATTERN = "[PVE][a-z0-9/]+";
    String CISCO_LOOP_PORT_PATTERN = "Lo0";
    String CISCO_VLAN_PORT_PATTERN = "Vlan\\d+";
    String CISCO_PORT_CONNECT_STATUS = "connected|notconnec|disabled|xcvrAbsen|noOperMem|down";
    String CISCO_PORT_DUPLEX = "full|auto|half";
    String CISCO_PORT_SPEED = "auto|\\d+G";
    //H3C
    String H3C_PORT_PATTERN = "[A-Z]+[0-9/]+";
    String H3C_LOOP_PORT_PATTERN = "Loop0";
    String H3C_VLAN_PORT_PATTERN = "Vlan\\d+";
    String H3C_PORT_CONNECT_STATUS = "UP|DOWN|ADM|Stby";
    String H3C_PORT_PHYSICAL_STATUS = "up|\\*?down";
    String H3C_PORT_PROTOCOL_STATUS = "up(?:\\(s\\))?|down(?:\\(s\\))?";
    String H3C_PORT_SPEED = "\\d+G(?:\\(a\\))?|auto";
    String H3C_PORT_DUPLEX = "A|F(?:\\(a\\))?|H(?:\\(a\\))?";
    String H3C_PORT_TYPE = "--|T|A|H";
    String H3C_PORT_IP_PATTERN = "--|" + IP_PATTERN;

    T generate(String src);
}
