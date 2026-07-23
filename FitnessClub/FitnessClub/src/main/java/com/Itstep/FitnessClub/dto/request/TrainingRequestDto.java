package com.Itstep.FitnessClub.dto.request;

public record TrainingRequestDto(
        Long trainingId,
        Long roomId,
        Long trainerId
) {
}
