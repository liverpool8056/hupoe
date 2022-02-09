package org.springfuture.network.bean;

import org.springfuture.network.manufacturer.Manufacturer;

import java.util.List;

public class Facts {
    private final String devName;
    private final Manufacturer manufacturer;
    private final String serialNum;
    private final String softwareVersion;

    public Facts(String devName, Manufacturer manufacturer, String serialNum, String softwareVersion) {
        this.devName = devName;
        this.manufacturer = manufacturer;
        this.serialNum = serialNum;
        this.softwareVersion = softwareVersion;
    }

    public String getDevName() {
        return devName;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public String getSoftwareVersion() {
        return softwareVersion;
    }

    @Override
    public String toString() {
        return "Facts{" +
                "devName='" + devName + '\'' +
                ", manufacturer=" + manufacturer +
                ", serialNum='" + serialNum + '\'' +
                ", softwareVersion='" + softwareVersion + '\'' +
                '}';
    }
}
