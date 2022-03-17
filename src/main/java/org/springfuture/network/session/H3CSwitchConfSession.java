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
        switchSession.sendCmd(""); // H3C don't support default interface in conf session
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
