package org.springfuture.network.session;

import org.springfuture.network.command.swCommand.processor.BasicIterableProcessor;
import org.springfuture.network.command.swCommand.processor.Processor;
import org.springfuture.network.device.SwitchDevice;
import org.springfuture.network.exception.OpenSessionException;
import org.springfuture.network.ssh.ExpectResult;

import java.util.List;

public abstract class AbstractSwitchSession extends AbstractDevSession implements SwitchSession {

    public AbstractSwitchSession(SwitchDevice switchDevice) {
        super(switchDevice);
    }

    protected <T> List<T> sendAndGetCollection(String cmd, Processor<T> processor) throws ExecutionException {
        ExpectResult expectResult = sendCmd(cmd);
        BasicIterableProcessor<T> basicIterableProcessor = new BasicIterableProcessor<>(expectResult, processor);
        return basicIterableProcessor.process();
    }

    @Override
    public void openSession(String username, String password) throws OpenSessionException {
        super.openSession(username, password);
        try {
            terminalLen();
        } catch (ExecutionException e) {
            throw new OpenSessionException(e);
        }
    }

}
