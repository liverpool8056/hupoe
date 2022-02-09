package org.springfuture.network.session;

public interface SwitchPortSession {
    SwitchSession end() throws ExecutionException;

    void exit();

    void setPortSwitchMode(String mode) throws ExecutionException;

    void setPortVlan(String vlanNum) throws ExecutionException;

    void setPortIntoPortGroup(String portGroupNum) throws ExecutionException;

    void setPortShutDown() throws ExecutionException;

    void setPortNoShutDown() throws ExecutionException;
}
