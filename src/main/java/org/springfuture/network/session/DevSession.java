package org.springfuture.network.session;

import org.springfuture.network.bean.Facts;
import org.springfuture.network.exception.OpenSessionException;
import org.springfuture.network.manufacturer.Manufacturer;
import org.springfuture.network.ssh.ExpectResult;

import java.io.Closeable;


public interface DevSession extends Closeable {
    void openSession(String name, String password) throws OpenSessionException;
    void closeSession();
    ExpectResult sendCmd(String cmd) throws ExecutionException;
//    void sendCmds(String[] cmd) throws ExecutionException;
//    ExpectResult expect() throws SessionReadException;
//    ExpectResult expect(int timeout) throws SessionReadException;
//    ExpectResult expect(List<String> expectedPrompts, int timeout) throws SessionReadException;
    Facts getFacts() throws ExecutionException;
    String getHostName() throws ExecutionException;
    Manufacturer getManufacturer();
}
