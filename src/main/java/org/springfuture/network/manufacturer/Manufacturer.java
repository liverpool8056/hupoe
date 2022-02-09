package org.springfuture.network.manufacturer;

import java.util.HashSet;

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

    public String[] alias(){
        HashSet<String> aliasSet = new HashSet<>();
        String lowerCaseName = name.toLowerCase();
        String capitalName = lowerCaseName.substring(0, lowerCaseName.length()-1) + lowerCaseName.substring(0, 0).toUpperCase();
        aliasSet.add(lowerCaseName);
        aliasSet.add(capitalName);
        return (String []) aliasSet.toArray();
    }
}
