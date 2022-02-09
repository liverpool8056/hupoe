package org.springfuture.network.session;

public class ExecutionException extends Exception{
    public ExecutionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExecutionException(Throwable cause) {
        super(cause);
    }

    public ExecutionException(String message) {
        super(message);
    }
}
