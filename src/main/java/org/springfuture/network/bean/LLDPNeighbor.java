package org.springfuture.network.bean;

import java.util.Objects;

public class LLDPNeighbor {
    private final String localPort;
    private final String remoteChassisId;
    private final String neighborName;
    private final String remotePort;
    private final String neighborAdminIp;

    public String getNeighborName() {
        return neighborName;
    }

    public String getNeighborAdminIp() {
        return neighborAdminIp;
    }

    public LLDPNeighbor(String localPort, String remoteChassisId, String neighborName, String remotePort, String neighborAdminIp) {
        this.localPort = localPort;
        this.remoteChassisId = remoteChassisId;
        this.neighborName = neighborName;
        this.remotePort = remotePort;
        this.neighborAdminIp = neighborAdminIp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LLDPNeighbor that = (LLDPNeighbor) o;
        return Objects.equals(neighborAdminIp, that.neighborAdminIp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(neighborAdminIp);
    }

    @Override
    public String toString() {
        return "LLDPNeighbor{" +
                "localPort='" + localPort + '\'' +
                ", remoteChassisId='" + remoteChassisId + '\'' +
                ", neighborName='" + neighborName + '\'' +
                ", remotePort='" + remotePort + '\'' +
                ", neighborAdminIp='" + neighborAdminIp + '\'' +
                '}';
    }
}
