package com.Itstep.FitnessClub.service;

import com.Itstep.FitnessClub.dto.request.TrainingChangeRequestDto;
import com.Itstep.FitnessClub.entity.Room;
import com.Itstep.FitnessClub.entity.Training;
import com.Itstep.FitnessClub.exception.ResourceNotFoundException;
import com.Itstep.FitnessClub.repository.RoomRepository;
import com.Itstep.FitnessClub.repository.TrainingRepositoryInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Внутренний сервис клуба.
 * Добавление, редактирование и удаление тренировок.
 */

@Service
@RequiredArgsConstructor
public class TrainingService {

    private final TrainingRepositoryInterface trainingRepository;
    private final RoomRepository roomRepository;

    public Training findTrainingById(Long trainingId) throws ResourceNotFoundException {
        return trainingRepository.findById(trainingId)
                .orElseThrow(() -> new ResourceNotFoundException("Training not found"));
    }

    public Training createTraining(TrainingChangeRequestDto trainingChangeRequestDto) {
        Training newTraining = new Training();
        newTraining.setTrainingType(trainingChangeRequestDto.trainingName());
        newTraining.setTrainingStart(trainingChangeRequestDto.trainingStart());
        newTraining.setTrainerName(trainingChangeRequestDto.trainerName());
        newTraining.setRoom(trainingChangeRequestDto.room());
        newTraining.setBookedCount(trainingChangeRequestDto.bookedCount());
        trainingRepository.save(newTraining);
        return newTraining;
    }

    public Training changeSchedule(Long trainingId, TrainingChangeRequestDto changes) {
        Training trainingFound = findTrainingById(trainingId);
        trainingFound.setTrainingId(trainingId);
        trainingFound.setTrainingType(changes.trainingName());
        trainingFound.setTrainingStart(changes.trainingStart());
        trainingFound.setTrainerName(changes.trainerName());
        trainingFound.setRoom(changes.room());
        trainingFound.setBookedCount(changes.bookedCount());
        return trainingFound;
    }

    public void deleteTraining(Long trainingId) {
        Training training = findTrainingById(trainingId);
        trainingRepository.delete(training);
    }

    public Room createRoom(Room room) {
        return roomRepository.createRoom(room);
    }
}
