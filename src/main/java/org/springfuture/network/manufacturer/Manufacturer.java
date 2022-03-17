package org.springfuture.network.manufacturer;

import java.util.ArrayList;
import java.util.List;

public enum Manufacturer {
    UNKNOWN("UNKNOWN"),
    H3C("H3C"),
    CISCO("CISCO");

    private String name;

    Manufacturer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<String> alias(){
        List<String> alias = new ArrayList<>();
        String lowerCaseName = name.toLowerCase();
        String capitalName = lowerCaseName.substring(0, 1).toUpperCase() +
                lowerCaseName.substring(1);
        alias.add(lowerCaseName);
        alias.add(capitalName);
        return alias;
    }
}
