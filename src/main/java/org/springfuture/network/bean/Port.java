package org.springfuture.network.bean;

public class Port {
    private final String name;
    private final String description;
    private String status;
    private final String protocolStatus;
    private final String physicalStatus;
    private final String adminStatus;
    private final String ip;

    public Port(String name, String physicalStatus, String protocolStatus, String adminStatus, String ip, String description) {
        this.name = name;
        this.physicalStatus = physicalStatus;
        this.protocolStatus = protocolStatus;
        this.adminStatus = adminStatus;
        this.ip = ip;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return adminStatus.equals("down") ? "down" :
                protocolStatus.contains("up") && physicalStatus.contains("up") ? "up" : "down";
    }

    public String getProtocolStatus() {
        return protocolStatus;
    }

    public String getPhysicalStatus() {
        return physicalStatus;
    }

    public String getIp() {
        return ip;
    }

    @Override
    public String toString() {
        return "Port{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status='" + getStatus() + '\'' +
                ", protocolStatus='" + protocolStatus + '\'' +
                ", physicalStatus='" + physicalStatus + '\'' +
                ", adminStatus='" + adminStatus + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}
