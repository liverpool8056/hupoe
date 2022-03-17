package org.springfuture.network.command.swCommand.processor;

import org.springfuture.network.device.SwitchDevice;

import java.util.regex.Pattern;

public class H3CMacTableProcessor extends BasicMacTableProcessor{

    private final static Pattern p =
            Pattern.compile("(?<mac>"+MAC_4_LOWER_DASH_PATTERN+")\\s+" +
                    "(?<vlanNum>\\d+)\\s+Learned\\s+(?<port>"+H3C_PORT_PATTERN+")");

    public H3CMacTableProcessor(SwitchDevice switchDevice) {
        super(switchDevice, p);
    }

    public H3CMacTableProcessor(){
        super(p);
    }
}
