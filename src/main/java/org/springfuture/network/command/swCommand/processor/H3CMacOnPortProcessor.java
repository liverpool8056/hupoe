package org.springfuture.network.command.swCommand.processor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class H3CMacOnPortProcessor extends NexusMacOnPortProcessor{

    private final static Pattern p =
            Pattern.compile("(?<mac>" + MAC_4_LOWER_DASH_PATTERN + ")");

    @Override
    public String generate(String src) {
        Matcher matcher = p.matcher(src);
        if (matcher.find()) {
            return matcher.group("mac");
        }
        return null;
    }

}
