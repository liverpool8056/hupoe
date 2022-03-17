package org.springfuture.network.command.swCommand.h3c;

import org.springfuture.network.command.CommandSet;

public class H3cDefaultCommandSet extends CommandSet {

    //setting
    public static final String TERMINAL_LEN = "screen-length disable";

    //conf
    public static final String CONF_PORT = "int %s";
    public static final String CONF_T = "sys";
    public static final String END = "end";
    public static final String EXIT = "exit";
    public static final String CONFIRM_YES = "y";
    public static final String CONFIRM_NO = "n";

    //arp
    private static final String GET_ARP = "display arp all";

    //mac
    private static final String GET_MAC_ON_PORT = "display mac-address inter %s";
    private static final String GET_MAC_ON_SWITCH = "display mac-address";
    //l3 interface
    private static final String GET_IP_INTERFACE_DETAIL = "display ip int %s";
    private static final String GET_IP_INTERFACE_BRIEF = "display ip int brief";
    //port
    private static final String GET_PORT_STATUS_LIST = "display interface brief description";
    private static final String GET_PORT_CONF = "display cur int %s";
    private static final String DEFAULT_PORT_CONFIG = "default\ny";
    private static final String SET_PORT_SWITCH_MODE = "port link-type %S";
    private static final String SET_PORT_VLAN = "port access vlan %s";
    private static final String SET_PORT_LINK_MODE = "port link-mode %s";
    private static final String PERMIT_PORT_TRUNK_VLAN = "port trunk permit vlan %s to %s";
    private static final String NO_PERMIT_PORT_TRUNK_VLAN = "undo port trunk permit vlan %s";
    private static final String SET_PORT_INTO_PORT_GROUP = "port link-aggregation group %s";
    private static final String SET_PORT_SHUTDOWN = "shut";
    private static final String SET_PORT_NO_SHUTDOWN = "undo shut";
    //port group
    private static final String GET_PORT_GROUP_LIST = "display interface bridge-aggregation brief description";
    private static final String SET_PORT_GROUP_AGGREGATION_MODE = "link-aggregation mode dynamic";
    private static final String CREATE_PORT_GROUP = "int Bridge-Aggregation %s";
    //vlan
    private static final String GET_VLAN_LIST = "display vlan brief";
    private static final String GET_VLAN_ID = "disp vlan %s";
    private static final String GET_L3_VLAN_DETAIL = "disp ip int vlan %s";
    private static final String CREATE_VLAN = "vlan %s";
    //neighbour
    public static final String SHOW_LLDP_NEIGHBORS_LIST = "display lldp neighbor-information list";
    public final static String SHOW_LLDP_NEIGHBORS_DETAIL = "display lldp neighbor-information verbose";

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

    public String confirmYes() {
        return CONFIRM_YES;
    }

    public String confirmNo() {
        return CONFIRM_NO;
    }

    @Override
    public String cmdGetInventory() {
        return "";
    }

    @Override
    public String cmdGetVersion() {
        return "";
    }

    @Override
    public String cmdGetHostname() {
        return "";
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
    public String cmdDefaultPortConfig(String portName) {
        return String.format(DEFAULT_PORT_CONFIG, portName);
    }

    @Override
    public String cmdSetPortSwitchMode(String switchMode) {
        return String.format(SET_PORT_SWITCH_MODE, switchMode);
    }

    @Override
    public String cmdSetPortVlan(int vlanNum) {
        return String.format(SET_PORT_VLAN, vlanNum);
    }

    public String cmdSetPortLinkMode(String mode) {
        return String.format(SET_PORT_LINK_MODE, mode);
    }

    @Override
    public String cmdSetPermitPortTrunkVlan(int vlanNumStart, int vlanNumEnd) {
        return String.format(PERMIT_PORT_TRUNK_VLAN, vlanNumStart, vlanNumEnd);
    }

    @Override
    public String cmdSetNoPermitPortTrunkVlan(int vlanNum) {
        return String.format(NO_PERMIT_PORT_TRUNK_VLAN, vlanNum);
    }

    @Override
    public String cmdSetPortIntoPortGroup(int portGroupNum) {
        return String.format(SET_PORT_INTO_PORT_GROUP, portGroupNum);
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

    public String cmdSetPortGroupAggMode(String aggregationMode) {
        return String.format(SET_PORT_GROUP_AGGREGATION_MODE, aggregationMode);
    }

    @Override
    public String cmdGetVlanList() {
        return GET_VLAN_LIST;
    }

    @Override
    public String cmdGetVlanDetail(int vlanNum) {
        return String.format(GET_VLAN_ID, vlanNum);
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
