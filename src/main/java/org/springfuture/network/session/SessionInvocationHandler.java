package org.springfuture.network.session;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SessionInvocationHandler implements InvocationHandler {

    private SwitchConfSession session;
    private String savePoint;

    public SessionInvocationHandler(SwitchConfSession session) {
        this.session = session;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().startsWith("default")){
            System.out.println("This is a set command, a save point should be setup");
            savePoint = "save";
        }
        return method.invoke(session, args);
    }

}
