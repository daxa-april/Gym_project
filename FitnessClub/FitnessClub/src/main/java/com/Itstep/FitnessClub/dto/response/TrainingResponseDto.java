package com.Itstep.FitnessClub.dto.response;

import java.time.LocalDateTime;

public record TrainingResponseDto(
        String trainingName,
        LocalDateTime trainingStart,
        String trainerName,
        String roomName,
        int bookedCount
) {
}
