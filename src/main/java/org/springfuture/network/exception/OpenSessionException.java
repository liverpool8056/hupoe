package org.springfuture.network.exception;

public class OpenSessionException extends Exception{

    public OpenSessionException(Throwable cause) {
        this("Can't open session", cause);
    }

    public OpenSessionException(String message, Throwable cause) {
        super(message, cause);
    }
}
