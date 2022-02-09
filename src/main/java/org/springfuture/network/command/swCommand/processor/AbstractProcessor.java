package org.springfuture.network.command.swCommand.processor;

import org.springfuture.network.device.SwitchDevice;

public abstract class AbstractProcessor <T> implements Processor<T>{
    protected final SwitchDevice device;

    public AbstractProcessor(SwitchDevice device) {
        this.device = device;
    }

    public AbstractProcessor(){
        this.device = new SwitchDevice();
    }
}
