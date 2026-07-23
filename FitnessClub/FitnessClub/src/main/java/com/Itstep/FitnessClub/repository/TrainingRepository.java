package com.Itstep.FitnessClub.repository;

import com.Itstep.FitnessClub.entity.Training;
import com.Itstep.FitnessClub.exception.TrainingNotFoundException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Хранит информацию о тренировках (место, время)
 */
@Setter
@Getter
@Repository
public class TrainingRepository {

    List<Training> trainings;

    public TrainingRepository(List<Training> trainings) {
        this.trainings = trainings;
    }

    public Training findTrainingById(Long trainingId) throws TrainingNotFoundException {
        Optional<Training> trainingForChanges = trainings.stream()
                .filter(training -> training.getTrainingId().equals(trainingId))
                .findFirst();
        if (trainingForChanges.isPresent()) {
            return trainingForChanges.get();
        } else {
            throw new TrainingNotFoundException("Training not found");
        }
    }

    public Training addTraining(Training training) {
        trainings.add(training);
        return training;
    }

    public void deleteTraining(Long trainingId) {
        trainings.remove(findTrainingById(trainingId));
    }
}
