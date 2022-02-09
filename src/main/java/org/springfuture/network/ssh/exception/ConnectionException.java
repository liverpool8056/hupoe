package org.springfuture.network.ssh.exception;

public class ConnectionException extends Exception{

    public ConnectionException(Throwable cause) {
        this("Connection Error", cause);
    }

    public ConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
