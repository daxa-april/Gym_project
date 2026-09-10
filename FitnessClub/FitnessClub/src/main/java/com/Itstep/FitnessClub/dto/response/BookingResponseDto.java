package com.Itstep.FitnessClub.dto.response;

import java.time.LocalDateTime;

public record BookingResponseDto(

        String fullName,
        String trainingName,
        LocalDateTime trainingStart,
        String trainer,
        String roomName
) {
}
