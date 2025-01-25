package com.example.demo.soap.models;

import java.util.Date;

public class BookingDTO {
    private Integer id;
    private String discountDescription;
    private Date reservationDate;

    public BookingDTO(Integer id, String discountDescription, Date reservationDate) {
        this.id = id;
        this.discountDescription = discountDescription;
        this.reservationDate = reservationDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDiscountDescription() {
        return discountDescription;
    }

    public void setDiscountDescription(String discountDescription) {
        this.discountDescription = discountDescription;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }
}

