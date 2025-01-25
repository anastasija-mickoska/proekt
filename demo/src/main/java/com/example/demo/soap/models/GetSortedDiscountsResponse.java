package com.example.demo.soap.models;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

import java.util.List;

@XmlRootElement(name = "GetSortedDiscountsResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetSortedDiscountsResponse {

    @XmlElement(name = "discounts")
    private List<com.example.demo.soap.models.Discount> discounts;

    public List<com.example.demo.soap.models.Discount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<com.example.demo.soap.models.Discount> discounts) {
        this.discounts = discounts;
    }
}
