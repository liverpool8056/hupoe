package org.springfuture.network.session;

import org.springfuture.network.command.CommandSet;

public class H3CSwitchPortSession extends AbstractSwitchPortSession{

    private final CommandSet commandSet;

    public H3CSwitchPortSession(SwitchSession switchSession, String portName) {
        super(switchSession, portName);
        this.commandSet = switchSession.getCommandSet();
    }

    @Override
    public SwitchSession end() throws ExecutionException {
        switchSession.sendCmd(commandSet.end());
        return switchSession;
    }

    @Override
    public void exit() {

    }

    @Override
    public void setPortSwitchMode(String mode) throws ExecutionException {
        switchSession.sendCmd(commandSet.cmdSetPortSwitchMode(mode));
    }

    @Override
    public void setPortVlan(String vlanNum) throws ExecutionException {
        switchSession.sendCmd(commandSet.cmdSetPortVlan(vlanNum));
    }

    @Override
    public void setPortIntoPortGroup(String portGroupNum) throws ExecutionException {
        switchSession.sendCmd(commandSet.cmdSetPortIntoPortGroup(portGroupNum));
    }

    @Override
    public void setPortShutDown() throws ExecutionException {
        switchSession.sendCmd(commandSet.cmdSetPortShutDown());
    }

    @Override
    public void setPortNoShutDown() throws ExecutionException {
        switchSession.sendCmd(commandSet.cmdSetPortNoShutDown());
    }
}
