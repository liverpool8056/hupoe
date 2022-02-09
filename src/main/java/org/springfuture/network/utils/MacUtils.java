package org.springfuture.network.utils;

import java.util.HashMap;
import java.util.Locale;

public class MacUtils {

    public final static HashMap<Integer, String> maskMap = new HashMap<>();

    static {
        maskMap.put(32, "255.255.255.255");     //1
        maskMap.put(31, "255.255.255.254");     //2
        maskMap.put(30, "255.255.255.252");     //4
        maskMap.put(29, "255.255.255.248");     //8
        maskMap.put(28, "255.255.255.240");     //16
        maskMap.put(27, "255.255.255.224");     //32
        maskMap.put(26, "255.255.255.192");     //64
        maskMap.put(25, "255.255.255.128");     //128
        maskMap.put(24, "255.255.255.0");       //256
        maskMap.put(23, "255.255.254.0");       //2
        maskMap.put(22, "255.255.252.0");       //4
        maskMap.put(21, "255.255.248.0");       //8
        maskMap.put(20, "255.255.240.0");       //16
        maskMap.put(19, "255.255.224.0");       //32
        maskMap.put(18, "255.255.192.0");       //64
        maskMap.put(17, "255.255.128.0");       //128
        maskMap.put(16, "255.255.0.0");         //256
    }
    /*
    from xxxx-xxxx-xxxx to xxxx.xxxx.xxxx, return characters are lowercase
     */
    public static String macFormatter(String mac){
        return mac.replace("-", ".").toLowerCase(Locale.ROOT);
    }
}
