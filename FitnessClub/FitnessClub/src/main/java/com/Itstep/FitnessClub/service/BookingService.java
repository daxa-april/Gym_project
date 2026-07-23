package com.Itstep.FitnessClub.service;

import com.Itstep.FitnessClub.dto.responce.BookingResponceDto;
import com.Itstep.FitnessClub.entity.Booking;
import com.Itstep.FitnessClub.repository.BookingRepository;
import org.springframework.stereotype.Service;

/**
 * Запись на тренировку + проверки: действует ли абонемент, есть ли доступные места в залах.
 */
@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    private BookingResponceDto mapToBookingResponce(Booking booking) {
        return new BookingResponceDto(
                booking.getClient().getFullName(),
                booking.getTraining().getTrainingName(),
                booking.getTraining().getTrainingStart(),
                booking.getTraining().getTrainerName(),
                booking.getRoom().getName()
        );
    }
}
