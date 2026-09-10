package com.Itstep.FitnessClub.controller;

import com.Itstep.FitnessClub.dto.request.BookingRequestDto;
import com.Itstep.FitnessClub.dto.responce.BookingResponceDto;
import com.Itstep.FitnessClub.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Отправка запросов по записи на занятия.
 */

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingOuterController {

    private final BookingService bookingService;

    @PostMapping("/book")
    public BookingResponceDto bookTraining(BookingRequestDto bookingRequestDto) {
        return bookingService.bookTraining(bookingRequestDto);
    }

}
