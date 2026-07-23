package com.Itstep.FitnessClub.dto.responce;

import java.time.LocalDateTime;

public record TrainingResponceDto(
        String trainingName,
        LocalDateTime trainingStart,
        String trainerName,
        String roomName,
        int bookedCount
) {
}
