package com.Itstep.FitnessClub.dto.responce;

import java.time.LocalDateTime;

public record BookingResponceDto(
        String fullName,
        String trainingName,
        LocalDateTime trainingStart,
        String trainer,
        String roomName
) {
}
