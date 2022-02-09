package org.springfuture.network.session;

public abstract class AbstractSwitchPortSession implements SwitchPortSession{

    protected final SwitchSession switchSession;
    protected final String portName;

    public AbstractSwitchPortSession(SwitchSession switchSession, String portName) {
        this.switchSession = switchSession;
        this.portName = portName;
    }
}
