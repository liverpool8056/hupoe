package org.springfuture.network.command.swCommand.processor;

import org.springfuture.network.bean.Segment;
import org.springfuture.network.utils.NetUtils;

public class H3CVlanDetailProcessor implements Processor<Segment>{

    @Override
    public Segment generate(String src) {
        int idx = src.indexOf("Internet Address is ");
        if(idx>=0){
            idx = idx + 20;
            String subnetStr = src.substring(idx).trim().split(" ")[0];
            String[] subnetSegs = subnetStr.split("/");
            Segment segment = new Segment(subnetSegs[0], NetUtils.maskMap.get(Integer.valueOf(subnetSegs[1])));
            return segment;
        }else return null;
    }
}
