package org.springfuture.network.command.swCommand.processor;

import org.springfuture.network.device.SwitchDevice;

import java.util.regex.Pattern;

public class NexusMacTableProcessor extends BasicMacTableProcessor {

    private final static Pattern p =
            Pattern.compile("(?<vlanNum>\\d+)\\s+(?<mac>"+MAC_4_LOWER_DOT_PATTERN+")\\s+" +
                    "(?<macType>dynamic|static)\\s+[\\d-]+\\s+[TF]\\s+[TF]\\s+(?<port>"+CISCO_PORT_PATTERN+")");

    public NexusMacTableProcessor(SwitchDevice device) {
        super(device, p);
    }

    public NexusMacTableProcessor() {
        super(p);
    }
}
