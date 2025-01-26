package com.example.demo.controller;

import com.example.demo.model.Discount;
import com.example.demo.service.DiscountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestServiceController {

    private final DiscountService discountService;

    public RestServiceController(DiscountService discountService) {
        this.discountService = discountService;
    }

    @GetMapping("/api/discounts/filter")
    public List<Discount> filterDiscounts(@RequestParam String destination) {
        return discountService.filterDiscountsByDestination(destination);
    }
}
