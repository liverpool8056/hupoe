package org.springfuture.network.session;

public interface SwitchConfSession {

    SwitchPortSession getPortSession(String portName) throws ExecutionException;

    void defaultPortConf(String portName) throws ExecutionException;

    void createVlan(String vlanNum) throws ExecutionException;

    void createPortGroup(String portGroupNum) throws ExecutionException;

    SwitchSession end() throws ExecutionException;
}
