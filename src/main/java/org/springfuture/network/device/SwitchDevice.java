package org.springfuture.network.device;

import org.springfuture.network.manufacturer.Manufacturer;

public class SwitchDevice {

        private String name;

        private String ip;

        private String location;

        private Integer peerId;

        private String devType;

        private Manufacturer manufacturer;

        private String model;

        private String softwareVersion;

        private String serialNum;

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getIp() {
                return ip;
        }

        public void setIp(String ip) {
                this.ip = ip;
        }

        public String getLocation() {
                return location;
        }

        public void setLocation(String location) {
                this.location = location;
        }

        public Integer getPeerId() {
                return peerId;
        }

        public void setPeerId(Integer peerId) {
                this.peerId = peerId;
        }

        public String getDevType() {
                return devType;
        }

        public void setDevType(String devType) {
                this.devType = devType;
        }

        public Manufacturer getManufacturer() {
                return manufacturer;
        }

        public void setManufacturer(Manufacturer manufacturer) {
                this.manufacturer = manufacturer;
        }

        public String getModel() {
                return model;
        }

        public void setModel(String model) {
                this.model = model;
        }

        public String getSoftwareVersion() {
                return softwareVersion;
        }

        public void setSoftwareVersion(String softwareVersion) {
                this.softwareVersion = softwareVersion;
        }

        public String getSerialNum() {
                return serialNum;
        }

        public void setSerialNum(String serialNum) {
                this.serialNum = serialNum;
        }

        @Override
        public String toString() {
                return "SwitchDevice{" +
                        "name='" + name + '\'' +
                        ", ip='" + ip + '\'' +
                        ", location='" + location + '\'' +
                        ", peerId=" + peerId +
                        ", devType='" + devType + '\'' +
                        ", manufacturer=" + manufacturer +
                        ", model='" + model + '\'' +
                        ", softwareVersion='" + softwareVersion + '\'' +
                        ", serialNum='" + serialNum + '\'' +
                        '}';
        }
}
