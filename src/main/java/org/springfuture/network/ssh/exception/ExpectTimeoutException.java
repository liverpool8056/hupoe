package org.springfuture.network.ssh.exception;

public class ExpectTimeoutException extends Exception{
    public ExpectTimeoutException() {
        this("Expect timeout");
    }

    public ExpectTimeoutException(String message) {
        super(message);
    }
}
