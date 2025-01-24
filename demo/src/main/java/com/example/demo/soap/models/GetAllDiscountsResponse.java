package com.example.demo.soap.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "GetAllDiscountsResponse")
public class GetAllDiscountsResponse {

    private List<com.example.demo.model.Discount> discounts;

    @XmlElement(name = "discount")
    public List<com.example.demo.model.Discount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<com.example.demo.model.Discount> discounts) {
        this.discounts = discounts;
    }
}
