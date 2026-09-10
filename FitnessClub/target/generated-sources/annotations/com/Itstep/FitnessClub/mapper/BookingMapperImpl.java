package com.Itstep.FitnessClub.mapper;

import com.Itstep.FitnessClub.dto.response.BookingResponseDto;
import com.Itstep.FitnessClub.entity.Booking;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-09-10T16:56:10+0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class BookingMapperImpl implements BookingMapper {

    @Override
    public BookingResponseDto bookingtoBookingResponceDto(Booking booking) {
        if ( booking == null ) {
            return null;
        }

        String fullName = null;
        String trainingName = null;
        LocalDateTime trainingStart = null;
        String trainer = null;
        String roomName = null;

        BookingResponseDto bookingResponseDto = new BookingResponseDto( fullName, trainingName, trainingStart, trainer, roomName );

        return bookingResponseDto;
    }
}
