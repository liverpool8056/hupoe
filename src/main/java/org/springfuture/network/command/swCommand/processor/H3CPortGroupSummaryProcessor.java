package org.springfuture.network.command.swCommand.processor;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class H3CPortGroupSummaryProcessor implements Processor<Integer> {

    private final static Pattern p =
            Pattern.compile("^BAGG(\\d+)");

    @Override
    public Integer generate(String src) {
        Matcher matcher = p.matcher(src);
        if(!matcher.find()) return null;
        return Integer.valueOf(matcher.group(1));
    }
}
