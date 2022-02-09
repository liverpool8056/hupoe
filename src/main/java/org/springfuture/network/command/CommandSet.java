package org.springfuture.network.command;

public abstract class CommandSet {

    //setting
    public abstract String cmdTerminalLen();

    //conf
    public abstract String port(String portName);
    public abstract String cmdConf();
    public abstract String end();
    public abstract String exit();

    //facts
    public abstract String cmdGetInventory();
    public abstract String cmdGetVersion();
    public abstract String cmdGetHostname();
    //arp
    public abstract String cmdGetArpOnSwitch();
    //mac
    public abstract String cmdGetMacOnPort(String portName);
    public abstract String cmdGetMacOnSwitch();
    //l3 interface
    public abstract String cmdGetIpInterfaceDetail(String portName);
    public abstract String cmdGetIpInterfaceBrief();
    //port
    public abstract String cmdGetPortStatusList();
    public abstract String cmdGetPortConf(String portName);
    public abstract String cmdDefaultPortConfig(String portName); //should be executed under port
    public abstract String cmdSetPortSwitchMode(String switchMode);
    public abstract String cmdSetPortVlan(String vlanNum);
    public abstract String cmdSetPermitPortTrunkVlan(String vlanNumStart, String vlanNumEnd);
    public abstract String cmdSetNoPermitPortTrunkVlan(String vlanNum);
    public abstract String cmdSetPortIntoPortGroup(String portGroupNum);
    public abstract String cmdSetPortShutDown();
    public abstract String cmdSetPortNoShutDown();
    //port group
    public abstract String cmdGetPortGroupList();
    public abstract String cmdCreatePortGroup(String portGroupNum);
    //vlan
    public abstract String cmdGetVlanList();
    public abstract String cmdGetVlanDetail(String vlanNum);
    public abstract String cmdCreateVlan(String vlanNum);
    //neighbour
    public abstract String cmdGetLLDPNeighborsList();
    public abstract String cmdGetLLDPNeighborsDetails();

}
