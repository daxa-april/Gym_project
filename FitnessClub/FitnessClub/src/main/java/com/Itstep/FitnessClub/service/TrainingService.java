package com.Itstep.FitnessClub.service;

import com.Itstep.FitnessClub.dto.request.TrainingChangeRequestDto;
import com.Itstep.FitnessClub.entity.Training;
import com.Itstep.FitnessClub.repository.TrainingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Добавление, редактирование и удаление тренировок.
 */

@Service
public class TrainingService {
    private final TrainingRepository trainingRepository;

    public TrainingService(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }


    public Training createTraining(TrainingChangeRequestDto trainingChangeRequestDto) {
        Training newTraining = new Training();
        newTraining.setTrainingName(trainingChangeRequestDto.trainingName());
        newTraining.setTrainingStart(trainingChangeRequestDto.trainingStart());
        newTraining.setTrainerName(trainingChangeRequestDto.trainerName());
        newTraining.setRoom(trainingChangeRequestDto.room());
        newTraining.setBookedCount(trainingChangeRequestDto.bookedCount());
        newTraining.setTrainingId(Long.parseLong(UUID.randomUUID().toString()));
        List<Training> trainings = trainingRepository.getTrainings();
        for (Training training : trainings) {
            if (training.getTrainingId().equals(newTraining.getTrainingId())) {
                newTraining.setTrainingId(Long.parseLong(UUID.randomUUID().toString()));
            }
            //todo: добавить трансформацию в дто, чтобы не отдавать сущности.
            trainingRepository.addTraining(newTraining);
            return newTraining;
        }
        return null;
    }

    public Training changeSchedule(Long trainingId, TrainingChangeRequestDto changes) {
        Training trainingFound = trainingRepository.findTrainingById(trainingId);
        trainingFound.setTrainingId(trainingId);
        trainingFound.setTrainingName(changes.trainingName());
        trainingFound.setTrainingStart(changes.trainingStart());
        trainingFound.setTrainerName(changes.trainerName());
        trainingFound.setRoom(changes.room());
        trainingFound.setBookedCount(changes.bookedCount());
        return trainingFound;
    }

    public void deleteTraining(Long trainingId) {
        trainingRepository.deleteTraining(trainingId);
    }
    //todo: добавить метод трансфер для перевода дто в тренировку.
}
