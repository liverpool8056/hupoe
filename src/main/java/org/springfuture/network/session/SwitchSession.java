package org.springfuture.network.session;

import org.springfuture.network.bean.*;
import org.springfuture.network.command.CommandSet;

import java.util.List;

public interface SwitchSession extends DevSession{

    boolean terminalLen() throws ExecutionException;

    List<Arp> getArpList() throws ExecutionException;

    List<String> getMacOnPort(String portName) throws ExecutionException;

    List<MacEntry> getMacTableOnSwitch() throws ExecutionException;

    Segment getIpInterfaceDetail(String portName) throws ExecutionException;

    List<Port> getIpInterfaceBrief() throws ExecutionException;

    List<PortStatus> getPortStatusList() throws ExecutionException;

    String getPortConfig(String port) throws ExecutionException;

    List<Integer> getPortGroupList() throws ExecutionException;

    List<L2Vlan> getVlanList() throws ExecutionException;

    Segment getL3VlanDetail(int vlanNum) throws ExecutionException;

    List<LLDPNeighbor> getLLDPNeighbors() throws ExecutionException;

    SwitchConfSession getConfSession() throws ExecutionException;

    SwitchPortSession getPortSession(String portName) throws ExecutionException;

    String rawCmd(String cmd) throws ExecutionException;

    CommandSet getCommandSet();
}
