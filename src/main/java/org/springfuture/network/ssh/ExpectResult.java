package org.springfuture.network.ssh;

public class ExpectResult implements Iterable<String>{
    private final boolean matched;
    private final Integer index;
    private final String matchedString;
    private final String output;

    public ExpectResult(boolean matched, Integer index, String matchedString, String output) {
        this.matched = matched;
        this.index = index;
        this.matchedString = matchedString;
        this.output = output;
    }

    public boolean isMatched() {
        return matched;
    }

    public Integer getIndex() {
        return index;
    }

    public String getMatchedString() {
        return matchedString;
    }

    public String getOutput() {
        return output;
    }

    public ResultIterator iterator(){
        return new ResultIterator(output);
    }
}
