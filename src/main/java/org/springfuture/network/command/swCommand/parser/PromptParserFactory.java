package org.springfuture.network.command.swCommand.parser;

import org.springfuture.network.command.swCommand.parser.h3c.H3cPromptParser;
import org.springfuture.network.device.SwitchDevice;
import org.springfuture.network.manufacturer.Manufacturer;

public class PromptParserFactory {
    public static PromptParser createParser(SwitchDevice switchDevice){
        Manufacturer manufacturer = switchDevice.getManufacturer();
        switch(manufacturer){
            case CISCO:
                return new BasePromptParser();
            case H3C:
                return new H3cPromptParser();
            default:
                throw new IllegalArgumentException("Can't provide promptParser, unknown manufacturer found: " + manufacturer);
        }
    }
}
