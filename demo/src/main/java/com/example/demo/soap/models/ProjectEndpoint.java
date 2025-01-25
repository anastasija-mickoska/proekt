package com.example.demo.soap.models;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.example.demo.service.BookingService;
import com.example.demo.service.DiscountService;

@Endpoint
public class ProjectEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/soap";

    private final BookingService bookingService;
    private final DiscountService discountService;

    public ProjectEndpoint(BookingService bookingService, DiscountService discountService) {
        this.bookingService = bookingService;
        this.discountService = discountService;
    }

    // Method 1: Get Bookings for a User
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetUserBookingsRequest")
    @ResponsePayload
    public GetUserBookingsResponse getUserBookings(@RequestPayload GetUserBookingsRequest request) {
        GetUserBookingsResponse response = new GetUserBookingsResponse();
        response.setBookings(bookingService.getBookingsByUserId(request.getUserId()));
        return response;
    }

    // Method 2: List All Discounts
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetDiscountsRequest")
    @ResponsePayload
    public GetAllDiscountsResponse getDiscounts() {
        GetAllDiscountsResponse response = new GetAllDiscountsResponse();
        response.setDiscounts(discountService.getAllDiscounts());
        return response;
    }
    
}
