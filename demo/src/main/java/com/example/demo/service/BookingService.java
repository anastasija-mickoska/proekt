package com.example.demo.service;

import java.util.List;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.DiscountRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.soap.models.BookingDTO;
import com.example.demo.model.Booking;
import com.example.demo.model.User;
import com.example.demo.model.Discount;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final DiscountRepository discountRepository;

    public BookingService(BookingRepository bookingRepository, UserRepository userRepository, DiscountRepository discountRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.discountRepository = discountRepository;
    }

    //get bookings for a particular user

    public List<BookingDTO> getBookingsByUserId(Integer userId) {
        List<Booking> bookings = bookingRepository.findByUserId(userId);
        return bookings.stream()
                .map(booking -> new BookingDTO(
                        booking.getId(),
                        booking.getDiscount().getDescription(),
                        booking.getReservationDate()))
                .toList();
    }

    //add booking 

    public Booking addBooking(Integer userId, Integer discountId, Date reservationDate) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        Discount discount = discountRepository.findById(discountId)
                .orElseThrow(() -> new IllegalArgumentException("Discount not found"));

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setDiscount(discount);
        booking.setReservationDate(reservationDate);

        return bookingRepository.save(booking);
    }
}
