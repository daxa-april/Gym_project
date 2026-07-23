package com.Itstep.FitnessClub.repository;

import com.Itstep.FitnessClub.entity.Booking;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Хранит записи на тренировки.
 */
@Repository
public class BookingRepository {

    List<Booking> bookings;

    public BookingRepository(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
