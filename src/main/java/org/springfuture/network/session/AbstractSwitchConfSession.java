package org.springfuture.network.session;

public abstract class AbstractSwitchConfSession implements SwitchConfSession{

    protected SwitchSession switchSession;

    public AbstractSwitchConfSession(SwitchSession switchSession) {
        this.switchSession = switchSession;
    }

}
