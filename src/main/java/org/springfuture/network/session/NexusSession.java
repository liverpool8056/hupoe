package org.springfuture.network.session;

import org.springfuture.network.bean.*;
import org.springfuture.network.command.CommandSet;
import org.springfuture.network.command.swCommand.cisco.CiscoDefaultCommandSet;
import org.springfuture.network.command.swCommand.processor.*;
import org.springfuture.network.device.SwitchDevice;
import org.springfuture.network.ssh.ExpectResult;

import java.util.List;

public class NexusSession extends AbstractSwitchSession {

    protected final static CommandSet COMMAND_SET = new CiscoDefaultCommandSet();

    public NexusSession(SwitchDevice switchDevice) {
        super(switchDevice);
    }

    @Override
    public boolean terminalLen() throws ExecutionException{
        ExpectResult expectResult = sendCmd(COMMAND_SET.cmdTerminalLen());
        return expectResult.isMatched();
    }

    @Override
    public List<Arp> getArpList() throws ExecutionException {
        ExpectResult expectResult = sendCmd(COMMAND_SET.cmdGetArpOnSwitch());
        BasicIterableProcessor<Arp> arpBasicIterableProcessor = new BasicIterableProcessor<>(expectResult, new NexusArpProcessor(switchDevice));
        return arpBasicIterableProcessor.process();
    }

    @Override
    public List<String> getMacOnPort(String portName) throws ExecutionException {
        ExpectResult expectResult = sendCmd(COMMAND_SET.cmdGetMacOnPort(portName));
        BasicIterableProcessor<String> macBasicIterableProcessor = new BasicIterableProcessor<>(expectResult, new NexusMacOnPortProcessor());
        return macBasicIterableProcessor.process();
    }

    @Override
    public List<MacEntry> getMacTableOnSwitch() throws ExecutionException {
        return sendAndGetCollection(COMMAND_SET.cmdGetMacOnSwitch(), new NexusMacTableProcessor(switchDevice));
    }

    @Override
    public Segment getIpInterfaceDetail(String portName) throws ExecutionException {
        ExpectResult expectResult = sendCmd(COMMAND_SET.cmdGetIpInterfaceDetail(portName));
        NexusVlanDetailProcessor nexusVlanDetailProcessor = new NexusVlanDetailProcessor();
        return nexusVlanDetailProcessor.generate(expectResult.getOutput());
    }

    @Override
    public List<Port> getIpInterfaceBrief() throws ExecutionException {
        return sendAndGetCollection(COMMAND_SET.cmdGetIpInterfaceBrief(), new NexusIpInterfaceBriefProcessor());
    }

    @Override
    public List<PortStatus> getPortStatusList() throws ExecutionException {
        return sendAndGetCollection(COMMAND_SET.cmdGetPortStatusList(), new NexusPortStatusProcessor());
    }

    @Override
    public String getPortConfig(String port) throws ExecutionException {
        ExpectResult expectResult = sendCmd(COMMAND_SET.cmdGetPortConf(port));
        return expectResult.getOutput();
    }

    @Override
    public List<Integer> getPortGroupList() throws ExecutionException {
        return sendAndGetCollection(COMMAND_SET.cmdGetPortGroupList(), new NexusPortChannelSummaryProcessor());
    }

    @Override
    public List<L2Vlan> getVlanList() throws ExecutionException {
        return sendAndGetCollection(COMMAND_SET.cmdGetVlanList(), new NexusVlanNameProcessor());
    }

    @Override
    public Segment getVlanDetail(String vlanNum) throws ExecutionException {
        ExpectResult expectResult = sendCmd(COMMAND_SET.cmdGetVlanDetail(vlanNum));
        NexusVlanDetailProcessor nexusVlanDetailProcessor = new NexusVlanDetailProcessor();
        return nexusVlanDetailProcessor.generate(expectResult.getOutput());
    }

    @Override
    public List<LLDPNeighbor> getLLDPNeighbors() throws ExecutionException {
        ExpectResult expectResult = sendCmd(COMMAND_SET.cmdGetLLDPNeighborsDetails());
        BasicIterableProcessor<LLDPNeighbor> lldpNeighborBasicIterableProcessor = new BasicIterableProcessor<>(expectResult, new NexusLLDPNeiDetailProcessor());
        return lldpNeighborBasicIterableProcessor.process();
    }

    @Override
    public SwitchConfSession getConfSession() throws ExecutionException {
        sendCmd(COMMAND_SET.cmdConf());
        return new NexusSwitchConfSession(this);
    }

    @Override
    public SwitchPortSession getPortSession(String portName) throws ExecutionException {
        return getConfSession().getPortSession(portName);
    }

    @Override
    public CommandSet getCommandSet() {
        return NexusSession.COMMAND_SET;
    }
}
