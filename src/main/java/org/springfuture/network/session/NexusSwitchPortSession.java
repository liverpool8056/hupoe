package org.springfuture.network.session;

import org.springfuture.network.command.CommandSet;

public class NexusSwitchPortSession extends AbstractSwitchPortSession{

    private final CommandSet commandSet;

    public NexusSwitchPortSession(SwitchSession switchSession, String portName) {
        super(switchSession, portName);
        commandSet = switchSession.getCommandSet();
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
    public void setPortVlan(String vlanNum) {

    }

    @Override
    public void setPortIntoPortGroup(String portGroupNum) {

    }

    @Override
    public void setPortShutDown() {

    }

    @Override
    public void setPortNoShutDown() {

    }
}
