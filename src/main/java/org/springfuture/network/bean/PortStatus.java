package org.springfuture.network.bean;

public class PortStatus {
    private final String name;
    private final String desc;
    private final String status;
    private final String vlan;
    private final String duplex;
    private final String speed;
    private final String type;

    public PortStatus(String name, String desc, String status, String vlan, String duplex, String speed, String type) {
        this.name = name;
        this.desc = desc;
        this.status = status;
        this.vlan = vlan;
        this.duplex = duplex;
        this.speed = speed;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getStatus() {
        return status;
    }

    public String getVlan() {
        return vlan;
    }

    public String getDuplex() {
        return duplex;
    }

    public String getSpeed() {
        return speed;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "PortStatus{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", status='" + status + '\'' +
                ", vlan='" + vlan + '\'' +
                ", duplex='" + duplex + '\'' +
                ", speed='" + speed + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
