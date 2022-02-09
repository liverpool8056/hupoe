package org.springfuture.network.ssh.exception;

public class ChannelClosedException extends Exception{
    public ChannelClosedException(Throwable e) {
        this("Channel unexpectedly closed", e);
    }

    public ChannelClosedException(String message, Throwable e) {
        super(message);
    }

    public ChannelClosedException() {
        this("Channel unexpectedly closed");
    }

    public ChannelClosedException(String message) {
        super(message);
    }
}
