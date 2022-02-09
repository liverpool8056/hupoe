package org.springfuture.network.exception;

public class SessionReadException extends Exception{

    public SessionReadException(String message, Throwable cause) {
        super(message, cause);
    }

    public SessionReadException(Throwable cause) {
        super(cause);
    }
}
