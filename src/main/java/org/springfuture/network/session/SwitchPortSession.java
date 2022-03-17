package org.springfuture.network.session;

import org.springfuture.network.command.swCommand.enums.PortSwitchMode;

public interface SwitchPortSession {
    SwitchSession end() throws ExecutionException;

    SwitchConfSession exit() throws ExecutionException;

    void defaultPortConfig() throws ExecutionException;

    void setPortSwitchMode(PortSwitchMode mode) throws ExecutionException;

    void setPortVlan(int vlanNum) throws ExecutionException;

    void setPortIntoPortGroupModeActive(int portGroupNum) throws ExecutionException;

    void setPortShutDown() throws ExecutionException;

    void setPortNoShutDown() throws ExecutionException;
}
