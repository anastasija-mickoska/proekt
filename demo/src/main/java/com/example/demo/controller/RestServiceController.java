package com.example.demo.controller;

import com.example.demo.model.Discount;
import com.example.demo.service.DiscountService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

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

    @PutMapping("/{id}")
    public ResponseEntity<Discount> updateDiscount(@PathVariable Integer id, @RequestBody Discount updatedDiscount) {
        try {
            Discount discount = discountService.updateDiscount(id, updatedDiscount);
            return ResponseEntity.ok(discount);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
