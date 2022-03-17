package org.springfuture.network.session;

import org.springfuture.network.command.CommandSet;
import org.springfuture.network.command.swCommand.enums.PortSwitchMode;

import java.util.ArrayList;

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
    public SwitchConfSession exit() throws ExecutionException {
        switchSession.sendCmd(commandSet.exit());
        return new H3CSwitchConfSession(switchSession);
    }

    @Override
    public void defaultPortConfig() throws ExecutionException {
        ArrayList<String> expectList = new ArrayList<>();
        expectList.add("[Y/N]:");
        switchSession.sendCmd("default", expectList, 3);
        switchSession.sendCmd(commandSet.confirmYes());
    }

    @Override
    public void setPortSwitchMode(PortSwitchMode mode) throws ExecutionException {
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
