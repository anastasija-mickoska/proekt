package com.example.demo.soap.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement(namespace = "http://example.com")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetUserBookingsResponse {
    @XmlElement(namespace = "http://example.com")
    private List<BookingDTO> bookings;

    public void setBookings(List<com.example.demo.soap.models.BookingDTO> bookings) {
        this.bookings = bookings;
    }
}
