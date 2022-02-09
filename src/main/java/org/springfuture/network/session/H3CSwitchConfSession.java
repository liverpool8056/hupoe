package org.springfuture.network.session;

import org.springfuture.network.command.CommandSet;

public class H3CSwitchConfSession extends AbstractSwitchConfSession{

    protected final CommandSet commandSet;

    public H3CSwitchConfSession(SwitchSession switchSession) {
        super(switchSession);
        this.commandSet = switchSession.getCommandSet();
    }

    @Override
    public SwitchPortSession getPortSession(String portName) throws ExecutionException {
        switchSession.sendCmd(commandSet.port(portName));
        return new H3CSwitchPortSession(switchSession, portName);
    }

    @Override
    public void defaultPortConf(String portName) throws ExecutionException {
        switchSession.sendCmd(commandSet.cmdDefaultPortConfig(portName));
    }

    @Override
    public void createVlan(String vlanNum) throws ExecutionException {
        switchSession.sendCmd(commandSet.cmdCreateVlan(vlanNum));
    }

    @Override
    public void createPortGroup(String portGroupNum) throws ExecutionException {
        switchSession.sendCmd(commandSet.cmdCreatePortGroup(portGroupNum));
    }

    @Override
    public SwitchSession end() throws ExecutionException {
        switchSession.sendCmd(commandSet.end());
        return switchSession;
    }
}
