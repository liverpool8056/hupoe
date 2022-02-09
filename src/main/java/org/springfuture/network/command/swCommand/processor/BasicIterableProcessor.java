package org.springfuture.network.command.swCommand.processor;

import java.util.ArrayList;
import java.util.List;

public class BasicIterableProcessor<T>{

    private final Iterable<String> iterable;

    private final Processor<T> processor;

    public BasicIterableProcessor(Iterable<String> iterator, Processor<T> processor) {
        this.iterable = iterator;
        this.processor = processor;
    }

    public List<T> process() {
        ArrayList<T> holderList = new ArrayList<>();
        for(String line : iterable){
            T generate = processor.generate(line);
            if(generate!=null){
                holderList.add(generate);
            }
        }
        return holderList;
    }
}
