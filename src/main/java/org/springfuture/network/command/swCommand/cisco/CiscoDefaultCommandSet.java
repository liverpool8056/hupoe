package org.springfuture.network.command.swCommand.cisco;

import org.springfuture.network.command.CommandSet;

public class CiscoDefaultCommandSet extends CommandSet {

    //setting
    public static final String TERMINAL_LEN = "ter len 0";

    //conf
    public static final String CONF_PORT = "int %s";
    public static final String CONF_T = "conf t";
    public static final String EXIT = "exit";
    public static final String END = "end";
    public static final String CONFIRM_YES = "y";

    //facts
    private static final String GET_INVENTORY = "show inventory";
    private static final String GET_VERSION = "show version";
    private static final String GET_HOSTNAME = "show hostname";
    //arp
    private static final String GET_ARP = "show ip arp";
    //mac
    private static final String GET_MAC_ON_PORT = "show mac address-table dynamic int %s";
    private static final String GET_MAC_ON_SWITCH = "show mac address-table";
    //l3 interface
    private static final String GET_IP_INTERFACE_DETAIL = "show ip inter %s";
    private static final String GET_IP_INTERFACE_BRIEF = "show ip int b";
    //port
    private static final String GET_PORT_STATUS_LIST = "show int status";
    private static final String GET_PORT_CONF = "show run int %s";
    private static final String SET_PORT_INTO_PORT_GROUP_MODE_ACTIVE = "channel-group %s mode active";
    private static final String DEFAULT_PORT_CONF = "default int %s";
    private static final String SET_PORT_SWITCH_MODE = "switchport mode %s";
    private static final String SET_PORT_VLAN = "switchport access vlan %s";
    private static final String ALLOW_VLAN = "switchport trunk allowed vlan %s";
    private static final String REMOVE_FROM_ALLOW_VLAN = "switchport trunk allowed vlan remove %s";
    public static final String SET_PORT_NO_SHUTDOWN = "no shutdown";
    public static final String SET_PORT_SHUTDOWN = "shutdown";
    //port group
    private static final String GET_PORT_GROUP_LIST = "show port-channel summary";
    private static final String SET_PORT_GROUP_AGGREGATION_MODE = "mode %s";
    private static final String CREATE_PORT_GROUP = "interface port-channel %s";
    //vlan
    private static final String GET_VLAN_LIST = "show vlan";
    private static final String GET_VLAN_DETAIL = "show vlan id %s";
    private static final String GET_L3_VLAN_DETAIL = "show ip int vlan %s";
    private static final String CREATE_VLAN = "vlan %s";
    //neighbour
    public static final String SHOW_LLDP_NEIGHBORS_DETAIL = "show lldp neighbors detail";
    public static final String SHOW_LLDP_NEIGHBORS_LIST = "show lldp neighbors";

    @Override
    public String cmdTerminalLen() {
        return TERMINAL_LEN;
    }

    @Override
    public String port(String portName) {
        return String.format(CONF_PORT, portName);
    }

    @Override
    public String cmdConf() {
        return CONF_T;
    }

    @Override
    public String end() {
        return END;
    }

    @Override
    public String exit() {
        return EXIT;
    }

    @Override
    public String confirmYes() {
        return CONFIRM_YES;
    }

    @Override
    public String cmdGetInventory() {
        return GET_INVENTORY;
    }

    @Override
    public String cmdGetVersion() {
        return GET_VERSION;
    }

    @Override
    public String cmdGetHostname() {
        return GET_HOSTNAME;
    }

    @Override
    public String cmdGetArpOnSwitch() {
        return GET_ARP;
    }

    @Override
    public String cmdGetMacOnPort(String portName) {
        return String.format(GET_MAC_ON_PORT, portName);
    }

    @Override
    public String cmdGetMacOnSwitch() {
        return GET_MAC_ON_SWITCH;
    }

    @Override
    public String cmdGetIpInterfaceDetail(String portName) {
        return String.format(GET_IP_INTERFACE_DETAIL, portName);
    }

    @Override
    public String cmdGetIpInterfaceBrief() {
        return GET_IP_INTERFACE_BRIEF;
    }

    @Override
    public String cmdGetPortStatusList() {
        return GET_PORT_STATUS_LIST;
    }

    @Override
    public String cmdGetPortConf(String port) {
        return String.format(GET_PORT_CONF, port);
    }

    @Override
    public String cmdSetPortIntoPortGroup(int portGroupNum) {
        return String.format(SET_PORT_INTO_PORT_GROUP_MODE_ACTIVE, portGroupNum);
    }

    @Override
    public String cmdDefaultPortConfig(String portName) {
        return String.format(DEFAULT_PORT_CONF, portName);
    }

    @Override
    public String cmdSetPortSwitchMode(String switchMode) {
        return String.format(SET_PORT_SWITCH_MODE, switchMode);
    }

    @Override
    public String cmdSetPortVlan(int vlanNum) {
        return String.format(SET_PORT_VLAN, vlanNum);
    }

    @Override
    public String cmdSetPermitPortTrunkVlan(int vlanNumStart, int vlanNumEnd) {
        return String.format(ALLOW_VLAN, vlanNumStart);
    }

    @Override
    public String cmdSetNoPermitPortTrunkVlan(int vlanNum) {
        return String.format(REMOVE_FROM_ALLOW_VLAN, vlanNum);
    }

    @Override
    public String cmdSetPortShutDown() {
        return SET_PORT_SHUTDOWN;
    }

    @Override
    public String cmdSetPortNoShutDown() {
        return SET_PORT_NO_SHUTDOWN;
    }

    @Override
    public String cmdGetPortGroupList() {
        return GET_PORT_GROUP_LIST;
    }

    @Override
    public String cmdCreatePortGroup(int portGroupNum) {
        return String.format(CREATE_PORT_GROUP, portGroupNum);
    }

    @Override
    public String cmdGetVlanList() {
        return GET_VLAN_LIST;
    }

    @Override
    public String cmdGetVlanDetail(int vlanNum) {
        return String.format(GET_VLAN_DETAIL, vlanNum);
    }

    @Override
    public String cmdGetL3VlanDetail(int vlanNum) {
        return String.format(GET_L3_VLAN_DETAIL, vlanNum);
    }

    @Override
    public String cmdCreateVlan(int vlanNum) {
        return String.format(CREATE_VLAN, vlanNum);
    }

    @Override
    public String cmdGetLLDPNeighborsList() {
        return SHOW_LLDP_NEIGHBORS_LIST;
    }

    @Override
    public String cmdGetLLDPNeighborsDetails() {
        return SHOW_LLDP_NEIGHBORS_DETAIL;
    }

}
