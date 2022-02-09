package org.springfuture.network.bean;

public class Arp {
    private final String ip;
    private final String mac;
    private final String switchIp;
    private final String port;

    public Arp(String ip, String mac, String switchIp, String port) {
        this.ip = ip;
        this.mac = mac;
        this.switchIp = switchIp;
        this.port = port;
    }

    public String getIp() {
        return ip;
    }

    public String getMac() {
        return mac;
    }

    public String getSwitchIp() {
        return switchIp;
    }

    public String getPort() {
        return port;
    }

    @Override
    public String toString() {
        return "Arp{" +
                "ip='" + ip + '\'' +
                ", mac='" + mac + '\'' +
                ", switchIp='" + switchIp + '\'' +
                ", port='" + port + '\'' +
                '}';
    }
}
