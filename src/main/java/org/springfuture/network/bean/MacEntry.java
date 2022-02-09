package org.springfuture.network.bean;

public class MacEntry {
    private final String mac;
    private final String vlan;
    private final String switchIp;
    private final String port;

    public MacEntry(String mac, String vlan, String switchIp, String port) {
        this.mac = mac;
        this.vlan = vlan;
        this.switchIp = switchIp;
        this.port = port;
    }

    public String getMac() {
        return mac;
    }

    public String getVlan() {
        return vlan;
    }

    public String getSwitchIp() {
        return switchIp;
    }

    public String getPort() {
        return port;
    }

    @Override
    public String toString() {
        return "MacEntry{" +
                "mac='" + mac + '\'' +
                ", vlan='" + vlan + '\'' +
                ", switchIp='" + switchIp + '\'' +
                ", port='" + port + '\'' +
                '}';
    }
}
