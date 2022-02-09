package org.springfuture.network.exception;

public class SessionClosedException extends Exception {
    public SessionClosedException(Throwable cause) {
        this("Session closed unexpectedly", cause);
    }

    public SessionClosedException(String message, Throwable cause) {
        super(message, cause);
    }
}
