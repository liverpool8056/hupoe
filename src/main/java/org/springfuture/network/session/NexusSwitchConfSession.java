package org.springfuture.network.session;

import org.springfuture.network.command.CommandSet;

public class NexusSwitchConfSession extends AbstractSwitchConfSession{

    protected final CommandSet commandSet;

    public NexusSwitchConfSession(SwitchSession switchSession) {
        super(switchSession);
        commandSet = switchSession.getCommandSet();
    }

    @Override
    public SwitchPortSession getPortSession(String portName) throws ExecutionException {
        switchSession.sendCmd(commandSet.port(portName));
        return new NexusSwitchPortSession(switchSession, portName);
    }

    @Override
    public void defaultPortConf(String portName) throws ExecutionException {
        switchSession.sendCmd(commandSet.cmdDefaultPortConfig(portName));
    }

    @Override
    public void createVlan(int vlanNum) throws ExecutionException {
        switchSession.sendCmd(commandSet.cmdCreateVlan(vlanNum));
    }

    @Override
    public void createPortGroup(int portGroupNum) throws ExecutionException {
        switchSession.sendCmd(commandSet.cmdCreatePortGroup(portGroupNum));
    }

    @Override
    public SwitchSession end() throws ExecutionException {
        switchSession.sendCmd(commandSet.end());
        return switchSession;
    }
}
