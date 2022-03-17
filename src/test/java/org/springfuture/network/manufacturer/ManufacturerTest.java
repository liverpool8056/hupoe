package org.springfuture.network.manufacturer;

import org.junit.Test;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManufacturerTest {

    @Test
    public void testManufacturer(){
        Manufacturer cisco = Manufacturer.CISCO;
        List<String> alias = cisco.alias();
        alias.forEach(System.out::println);
    }

    @Test
    public void test(){
        String prompt = "";
            for(Manufacturer manufacturer : Manufacturer.values()) {
                for (String alia : manufacturer.alias()) {
                    if (prompt.contains(alia)) {
                        System.out.println(manufacturer);
                    }
                }
            }
        System.out.println("not found");
    }

}