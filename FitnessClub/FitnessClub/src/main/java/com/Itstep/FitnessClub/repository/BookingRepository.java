package com.Itstep.FitnessClub.repository;

import com.Itstep.FitnessClub.entity.Booking;

import java.util.List;

public class BookingRepository {

    List<Booking> bookings;

    public BookingRepository(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
