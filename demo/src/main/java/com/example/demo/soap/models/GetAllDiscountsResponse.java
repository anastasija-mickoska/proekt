package com.example.demo.soap.models;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "GetAllDiscountsResponse")
public class GetAllDiscountsResponse {

    private List<com.example.demo.soap.models.Discount> discounts;

    @XmlElement(name = "discounts")
    public List<com.example.demo.soap.models.Discount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<com.example.demo.soap.models.Discount> discounts) {
        this.discounts = discounts;
    }
}
