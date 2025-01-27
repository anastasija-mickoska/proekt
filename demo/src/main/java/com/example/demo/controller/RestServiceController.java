package com.example.demo.controller;

import com.example.demo.model.Booking;
import com.example.demo.model.Discount;
import com.example.demo.service.BookingService;
import com.example.demo.service.DiscountService;
import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class RestServiceController {

    private final DiscountService discountService;
    private final BookingService bookingService;

    public RestServiceController(DiscountService discountService, BookingService bookingService) {
        this.discountService = discountService;
        this.bookingService = bookingService;
    }

    //filter discounts by destination name or destination country

    @GetMapping("/api/discounts/filter")
    public List<Discount> filterDiscounts(@RequestParam String destination) {
        return discountService.filterDiscountsByDestination(destination);
    }

    //update discount

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

    //add booking

    @PostMapping("/bookings")
    public ResponseEntity<Booking> addBooking(@RequestParam Integer userId, @RequestParam Integer discountId, @RequestParam Date reservationDate) {
        Booking booking = bookingService.addBooking(userId, discountId, reservationDate);
        return ResponseEntity.ok(booking);
    }

    @GetMapping("/bookings")
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
        return ResponseEntity.ok(bookings);
    }

    @GetMapping("/bookings/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Integer id) {
        Booking booking = bookingService.getBookingById(id);
        return ResponseEntity.ok(booking);
    }

    @DeleteMapping("/bookings/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Integer id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }
}
