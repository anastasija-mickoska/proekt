package com.example.demo.service;

import java.util.List;
import com.example.demo.repository.BookingRepository;
import com.example.demo.soap.models.BookingDTO;
import com.example.demo.model.Booking;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<BookingDTO> getBookingsByUserId(Integer userId) {
        List<Booking> bookings = bookingRepository.findByUserId(userId);
        return bookings.stream()
                .map(booking -> new BookingDTO(
                        booking.getId(),
                        booking.getDiscount().getDescription(),
                        booking.getReservationDate()))
                .toList();
    }
}
