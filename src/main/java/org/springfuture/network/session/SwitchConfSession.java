package org.springfuture.network.session;

public interface SwitchConfSession {

    SwitchPortSession getPortSession(String portName) throws ExecutionException;

    void defaultPortConf(String portName) throws ExecutionException;

    void createVlan(int vlanNum) throws ExecutionException;

    void createPortGroup(int portGroupNum) throws ExecutionException;

    SwitchSession end() throws ExecutionException;
}
