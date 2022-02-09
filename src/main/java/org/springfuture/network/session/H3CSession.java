package org.springfuture.network.session;

import org.springfuture.network.bean.*;
import org.springfuture.network.command.CommandSet;
import org.springfuture.network.command.swCommand.h3c.H3cDefaultCommandSet;
import org.springfuture.network.command.swCommand.processor.*;
import org.springfuture.network.device.SwitchDevice;
import org.springfuture.network.ssh.ExpectResult;

import java.util.*;

public class H3CSession extends AbstractSwitchSession {

    protected final static CommandSet DEFAULT_COMMAND_SET = new H3cDefaultCommandSet();
    private final CommandSet commandSet = DEFAULT_COMMAND_SET;
    private final static String ERROR_PATTERN = "% Unrecognized command found";

    public H3CSession(SwitchDevice switchDevice) {
        super(switchDevice);
    }

    @Override
    public boolean terminalLen() throws ExecutionException {
        ExpectResult expectResult = sendCmd(commandSet.cmdTerminalLen());
        return expectResult.isMatched();
    }

    @Override
    public List<Arp> getArpList() throws ExecutionException {
        return sendAndGetCollection(commandSet.cmdGetArpOnSwitch(), new H3CArpProcessor(switchDevice));
    }

    @Override
    public List<String> getMacOnPort(String portName) throws ExecutionException {
        return sendAndGetCollection(commandSet.cmdGetMacOnPort(portName), new H3CMacOnPortProcessor());
    }

    @Override
    public List<MacEntry> getMacTableOnSwitch() throws ExecutionException {
        return sendAndGetCollection(commandSet.cmdGetMacOnSwitch(), new H3CMacTableProcessor());
    }

    @Override
    public Segment getIpInterfaceDetail(String portName) throws ExecutionException {
        ExpectResult expectResult = sendCmd(commandSet.cmdGetIpInterfaceDetail(portName));
        H3CVlanDetailProcessor vlanDetailProcessor = new H3CVlanDetailProcessor();
        return vlanDetailProcessor.generate(expectResult.getOutput());
    }

    @Override
    public List<Port> getIpInterfaceBrief() throws ExecutionException {
        return sendAndGetCollection(commandSet.cmdGetIpInterfaceBrief(), new H3CIpInterfaceBriefProcessor());
    }

    @Override
    public List<PortStatus> getPortStatusList() throws ExecutionException {
        return sendAndGetCollection(commandSet.cmdGetPortStatusList(), new H3CPortStatusProcessor());
    }

    @Override
    public String getPortConfig(String port) throws ExecutionException {
        ExpectResult expectResult = sendCmd(commandSet.cmdGetPortConf(port));
        return expectResult.getOutput();
    }

    @Override
    public List<Integer> getPortGroupList() throws ExecutionException {
        return sendAndGetCollection(commandSet.cmdGetPortGroupList(), new H3CPortGroupSummaryProcessor());
    }

    @Override
    public List<L2Vlan> getVlanList() throws ExecutionException {
        return sendAndGetCollection(commandSet.cmdGetVlanList(), new H3CVlanNameProcessor());
    }

    @Override
    public Segment getVlanDetail(String vlanNum) throws ExecutionException {
        ExpectResult expectResult = sendCmd(commandSet.cmdGetVlanDetail(vlanNum));
        H3CVlanDetailProcessor h3CVlanDetailProcessor = new H3CVlanDetailProcessor();
        return h3CVlanDetailProcessor.generate(expectResult.getOutput());
    }

    @Override
    public SwitchConfSession getConfSession() throws ExecutionException {
        sendCmd(commandSet.cmdConf());
        return new H3CSwitchConfSession(this);
    }

    @Override
    public List<LLDPNeighbor> getLLDPNeighbors() throws ExecutionException {
        return sendAndGetCollection(commandSet.cmdGetLLDPNeighborsDetails(), new H3CLLDPNeiDetailProcessor());
    }

    @Override
    public SwitchPortSession getPortSession(String portName) throws ExecutionException {
        return getConfSession().getPortSession(portName);
    }

    @Override
    public CommandSet getCommandSet() {
        return H3CSession.DEFAULT_COMMAND_SET;
    }

    @Override
    protected boolean checkValidCommand(String output) {
        return output == null ? true : output.contains(ERROR_PATTERN);
    }

}
