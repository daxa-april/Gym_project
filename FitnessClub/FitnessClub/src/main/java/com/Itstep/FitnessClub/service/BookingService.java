package com.Itstep.FitnessClub.service;

import com.Itstep.FitnessClub.dto.request.BookingRequestDto;
import com.Itstep.FitnessClub.dto.responce.BookingResponceDto;
import com.Itstep.FitnessClub.entity.Booking;
import com.Itstep.FitnessClub.entity.Client;
import com.Itstep.FitnessClub.entity.Subscription;
import com.Itstep.FitnessClub.entity.Training;
import com.Itstep.FitnessClub.exception.NoPlaceAvailableException;
import com.Itstep.FitnessClub.exception.ResourceNotFoundException;
import com.Itstep.FitnessClub.exception.SubscriptionExpiredException;
import com.Itstep.FitnessClub.mapper.BookingMapper;
import com.Itstep.FitnessClub.repository.BookingRepository;
import com.Itstep.FitnessClub.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Запись на тренировку + проверки: действует ли абонемент, есть ли доступные места в залах.
 */
@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final TrainingService trainingService;
    private final ClientRepository clientRepository;
    private final BookingMapper bookingMapper;

    public BookingResponceDto bookTraining(BookingRequestDto bookingRequestDto) {
        Client client = clientRepository.findById(bookingRequestDto.clientId())
                .orElseThrow(() -> new ResourceNotFoundException("Client not found"));

        Training training = trainingService.findTrainingById(bookingRequestDto.workoutId());

        Subscription subscription = client.getSubscription();
        if (subscription == null || !subscription.isActive()) {
            throw new SubscriptionExpiredException("Subscription not found or has already expired");
        }

        if (bookingRepository.existsByClientAndTraining(client, training)) {
            throw new IllegalArgumentException("Training has already been booked");
        }

        long bookedCount = bookingRepository.countByTraining(training);
        if (bookedCount >= training.getRoom().getCapacity()) {
            throw new NoPlaceAvailableException("No places available");
        }

        Booking booking = new Booking(null, client, training, LocalDateTime.now());
        bookingRepository.save(booking);
        return bookingMapper.bookingtoBookingResponceDto(booking);
    }

}
