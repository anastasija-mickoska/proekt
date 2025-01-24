package com.example.demo.soap.models;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.soap.server.endpoint.annotation.SoapAction;

import com.example.demo.service.DiscountService;

@Endpoint
public class DiscountEndpoint {
    
    private static final String NAMESPACE_URI = "http://example.com/demo/soap";

    private final DiscountService discountService;

    public DiscountEndpoint(DiscountService discountService) {
        this.discountService = discountService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetAllDiscountsRequest")
    @ResponsePayload
    public GetAllDiscountsResponse getAllDiscounts() {
        GetAllDiscountsResponse response = new GetAllDiscountsResponse();
        response.setDiscounts(discountService.getAllDiscounts());
        return response;
    }
}
