package org.springfuture.network.command;

import org.springfuture.network.command.swCommand.cisco.CiscoDefaultCommandSet;
import org.springfuture.network.command.swCommand.h3c.H3cDefaultCommandSet;
import org.springfuture.network.manufacturer.Manufacturer;

public class CommandSetFactory {

    public static CommandSet createCmdSet(Manufacturer manufacturer){
        if(manufacturer==null) manufacturer=Manufacturer.UNKNOWN;
        switch(manufacturer){
            case CISCO:
                return new CiscoDefaultCommandSet();
            case H3C:
                return new H3cDefaultCommandSet();
            default:
                throw new IllegalArgumentException("Can't provide commandSet, unknown manufacturer found: " + manufacturer);
        }
    }
}
