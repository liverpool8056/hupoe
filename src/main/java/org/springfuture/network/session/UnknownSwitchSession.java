package org.springfuture.network.session;

import org.springfuture.network.bean.*;
import org.springfuture.network.command.CommandSet;
import org.springfuture.network.device.SwitchDevice;

import java.util.Collections;
import java.util.List;

public class UnknownSwitchSession extends AbstractSwitchSession{

    public UnknownSwitchSession(SwitchDevice switchDevice) {
        super(switchDevice);
    }

    @Override
    public boolean terminalLen() throws ExecutionException {
        return false;
    }

    @Override
    public List<Arp> getArpList() throws ExecutionException {
        return Collections.emptyList();
    }

    @Override
    public List<String> getMacOnPort(String portName) throws ExecutionException {
        return Collections.emptyList();
    }

    @Override
    public List<MacEntry> getMacTableOnSwitch() throws ExecutionException {
        return Collections.emptyList();
    }

    @Override
    public Segment getIpInterfaceDetail(String portName) throws ExecutionException {
        return null;
    }

    @Override
    public List<Port> getIpInterfaceBrief() throws ExecutionException {
        return Collections.emptyList();
    }

    @Override
    public List<PortStatus> getPortStatusList() throws ExecutionException {
        return Collections.emptyList();
    }

    @Override
    public String getPortConfig(String port) throws ExecutionException {
        return "";
    }

    @Override
    public List<Integer> getPortGroupList() throws ExecutionException {
        return Collections.emptyList();
    }

    @Override
    public List<L2Vlan> getVlanList() throws ExecutionException {
        return Collections.emptyList();
    }

    @Override
    public Segment getL3VlanDetail(int vlanNum) throws ExecutionException {
        return null;
    }

    @Override
    public List<LLDPNeighbor> getLLDPNeighbors() throws ExecutionException {
        return Collections.emptyList();
    }

    @Override
    public SwitchConfSession getConfSession() throws ExecutionException {
        return null;
    }

    @Override
    public SwitchPortSession getPortSession(String portName) throws ExecutionException {
        return null;
    }

    @Override
    public CommandSet getCommandSet() {
        return null;
    }
}
