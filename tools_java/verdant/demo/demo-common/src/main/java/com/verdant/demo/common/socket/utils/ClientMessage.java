package com.verdant.demo.common.socket.utils;

/**
 * Created by Administrator on 2016/5/11.
 */
public class ClientMessage {
    private String host;
    private Integer port;
    private String message;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
