package com.java.konwledge.basicinfo.util;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *  @dept 上海软件研发中心
 *  @description TODO
 *  @author HaoXin.Liu
 *  @date 2020/7/22 10:45
 **/
@XmlRootElement(name = "response")
public class YiTuTokenInfo {
    private String cmdUrl;
    private String status;
    private YituLoginContent content;

    @XmlAttribute(name = "cmdUrl")
    public String getCmdUrl() {
        return cmdUrl;
    }

    public void setCmdUrl(String cmdUrl) {
        this.cmdUrl = cmdUrl;
    }

    @XmlElement(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    @XmlElement(name = "content")
    public YituLoginContent getContent() {
        return content;
    }

    public void setContent(YituLoginContent content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "YiTuTokenInfo{" +
                "cmdUrl='" + cmdUrl + '\'' +
                ", status='" + status + '\'' +
                ", content=" + content +
                '}';
    }


}