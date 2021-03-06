package com.nettyrpc.interfaces;

import java.io.Serializable;
import java.util.List;

public class ServerData implements Serializable {
    private List<String> serverInterfaces;
    private String serverIp;
    private String serverPort;

    public List<String> getServerInterfaces() {
        return serverInterfaces;
    }

    public void setServerInterfaces(List<String> serverInterfaces) {
        this.serverInterfaces = serverInterfaces;
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public String getServerPort() {
        return serverPort;
    }

    public void setServerPort(String serverPort) {
        this.serverPort = serverPort;
    }
}
