package org.springfuture.network.session;

import org.springfuture.network.command.CommandSet;
import org.springfuture.network.command.swCommand.enums.PortSwitchMode;

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
    public SwitchConfSession exit() throws ExecutionException {
        switchSession.sendCmd(commandSet.exit());
        return new NexusSwitchConfSession(switchSession);
    }

    @Override
    public void defaultPortConfig() {
        //cisco don't support default interface in port session
    }

    @Override
    public void setPortSwitchMode(PortSwitchMode mode) throws ExecutionException {
        switchSession.sendCmd("switchport");
        switchSession.sendCmd(commandSet.cmdSetPortSwitchMode(mode.getMode()));
    }

    @Override
    public void setPortVlan(int vlanNum) throws ExecutionException {
        switchSession.sendCmd(commandSet.cmdSetPortVlan(vlanNum));
    }

    @Override
    public void setPortIntoPortGroupModeActive(int portGroupNum) throws ExecutionException {
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
