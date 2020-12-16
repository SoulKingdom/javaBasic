package com.java.konwledge.basicinfo.util;

import javax.xml.bind.annotation.XmlElement;

/**
 *  @dept 上海软件研发中心
 *  @description TODO
 *  @author HaoXin.Liu
 *  @date 2020/7/22 10:47
 **/
public class YituLoginContent {

    private String sessionId;
    private String nonce;
    private String token;
    private String softwareVersion;

    @XmlElement(name = "sessionId")
    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @XmlElement(name = "nonce")
    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    @XmlElement(name = "token")
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @XmlElement(name = "softwareVersion")
    public String getSoftwareVersion() {
        return softwareVersion;
    }

    public void setSoftwareVersion(String softwareVersion) {
        this.softwareVersion = softwareVersion;
    }

    @Override
    public String toString() {
        return "YituLoginContent{" +
                "sessionId='" + sessionId + '\'' +
                ", nonce='" + nonce + '\'' +
                ", token='" + token + '\'' +
                ", softwareVersion='" + softwareVersion + '\'' +
                '}';
    }
}