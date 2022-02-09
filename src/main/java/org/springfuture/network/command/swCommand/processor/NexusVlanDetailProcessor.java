package org.springfuture.network.command.swCommand.processor;

import org.springfuture.network.bean.Segment;
import org.springfuture.network.utils.MacUtils;

import java.util.HashMap;

public class NexusVlanDetailProcessor implements Processor<Segment>{

    @Override
    public Segment generate(String src) {

        String[] lines = src.split("\n");
        for(String line: lines){
            int idx = line.indexOf("IP subnet:");
            if(idx>0){
                idx = idx + 10;
                String subnetStr = line.substring(idx).trim();
                String[] subnetSegs = subnetStr.split("/");
                idx = subnetSegs[1].indexOf(" ");
                if(idx > 0) subnetSegs[1] = subnetSegs[1].substring(0, idx);
                return new Segment(subnetSegs[0], MacUtils.maskMap.get(Integer.valueOf(subnetSegs[1])));
            }
        }
        return null;
    }
}
