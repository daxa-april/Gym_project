package com.Itstep.FitnessClub.service;

import com.Itstep.FitnessClub.dto.responce.TrainingResponceDto;
import com.Itstep.FitnessClub.entity.Training;
import com.Itstep.FitnessClub.repository.TrainingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * вывод расписания.
 */
@Service
public class ScheduleService {

    private final TrainingRepository trainingRepository;

    public ScheduleService(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    public List<TrainingResponceDto> getSchedule() {
        List<Training> trainings = trainingRepository.getTrainings();
        return trainings.stream()
                .map(this::mapToTrainingResponceDto)
                .toList();
    }

    private TrainingResponceDto mapToTrainingResponceDto(Training training) {
        return new TrainingResponceDto(
                training.getTrainingName(),
                training.getTrainingStart(),
                training.getTrainerName(),
                training.getRoom().getName(),
                training.getBookedCount()
        );
    }
}
