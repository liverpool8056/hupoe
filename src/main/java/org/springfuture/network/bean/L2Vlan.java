package org.springfuture.network.bean;

public class L2Vlan {
    private final String name;
    private final int vlanNum;

    public L2Vlan(String name, int vlanNum) {
        this.name = name;
        this.vlanNum = vlanNum;
    }

    public String getName() {
        return name;
    }

    public int getVlanNum() {
        return vlanNum;
    }

    @Override
    public String toString() {
        return "L2Vlan{" +
                "name='" + name + '\'' +
                ", vlanNum=" + vlanNum +
                '}';
    }
}
