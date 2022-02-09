package org.springfuture.network.session;

import org.springfuture.network.device.SwitchDevice;
import org.springfuture.network.exception.OpenSessionException;
import org.springfuture.network.manufacturer.Manufacturer;

public class SwitchSessionFactory {

    public static SwitchSession buildSession(SwitchDevice switchDevice, String username, String password) throws OpenSessionException {
        Manufacturer manufacturer = switchDevice.getManufacturer();
        if(manufacturer==null) manufacturer=Manufacturer.UNKNOWN;
        switch (manufacturer){
            case H3C:
                H3CSession h3CSession = new H3CSession(switchDevice);
                h3CSession.openSession(username, password);
                return h3CSession;
            case CISCO:
            case UNKNOWN:
            default:
                NexusSession nexusSession = new NexusSession(switchDevice);
                nexusSession.openSession(username, password);
                return nexusSession;
        }
    }
}
