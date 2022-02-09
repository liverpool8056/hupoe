package org.springfuture.network.ssh;

import java.util.Iterator;

public class ResultIterator implements Iterator<String>{

    private final static String DEFAULT_REGEX = "\n";

    private final int size;

    private int count = 0;

    private final String[] prompts;

    public ResultIterator(String prompt){
        this(prompt, DEFAULT_REGEX);
    }

    public ResultIterator(String prompt, String regex) {
        prompts = prompt.split(regex);
        size = prompts.length;
    }

    @Override
    public boolean hasNext() {
        return count<size;
    }

    @Override
    public String next() {
        return prompts[count++];
    }
}
