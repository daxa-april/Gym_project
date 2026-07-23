package com.Itstep.FitnessClub.dto.request;

import com.Itstep.FitnessClub.entity.Room;

import java.time.LocalDateTime;

public record TrainingChangeRequestDto(
        String trainingName,
        LocalDateTime trainingStart,
        String trainerName,
        Room room,
        int bookedCount

) {
    @Override
    public String trainingName() {
        return trainingName;
    }

    @Override
    public LocalDateTime trainingStart() {
        return trainingStart;
    }

    @Override
    public String trainerName() {
        return trainerName;
    }

    @Override
    public Room room() {
        return room;
    }

    @Override
    public int bookedCount() {
        return bookedCount;
    }
}
