package org.springfuture.network.command;

public abstract class CommandSet {

    //setting
    public abstract String cmdTerminalLen();

    //conf
    public abstract String port(String portName);
    public abstract String cmdConf();
    public abstract String end();
    public abstract String exit();
    public abstract String confirmYes();

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
    public abstract String cmdSetPortVlan(int vlanNum);
    public abstract String cmdSetPermitPortTrunkVlan(int vlanNumStart, int vlanNumEnd);
    public abstract String cmdSetNoPermitPortTrunkVlan(int vlanNum);
    public abstract String cmdSetPortIntoPortGroup(int portGroupNum);
    public abstract String cmdSetPortShutDown();
    public abstract String cmdSetPortNoShutDown();
    //port group
    public abstract String cmdGetPortGroupList();
    public abstract String cmdCreatePortGroup(int portGroupNum);
    //vlan
    public abstract String cmdGetVlanList();
    public abstract String cmdGetVlanDetail(int vlanNum);
    public abstract String cmdGetL3VlanDetail(int vlanNum);
    public abstract String cmdCreateVlan(int vlanNum);
    //neighbour
    public abstract String cmdGetLLDPNeighborsList();
    public abstract String cmdGetLLDPNeighborsDetails();

}
