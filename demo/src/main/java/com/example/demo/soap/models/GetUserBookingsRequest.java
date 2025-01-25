package com.example.demo.soap.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement(namespace = "http://example.com")
@XmlAccessorType(XmlAccessType.FIELD)

public class GetUserBookingsRequest {
    @XmlElement(namespace = "http://example.com", required = true)
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
