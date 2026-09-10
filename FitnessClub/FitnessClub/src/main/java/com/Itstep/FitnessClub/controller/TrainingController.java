package com.Itstep.FitnessClub.controller;

import com.Itstep.FitnessClub.dto.request.TrainingChangeRequestDto;
import com.Itstep.FitnessClub.entity.Room;
import com.Itstep.FitnessClub.entity.Training;
import com.Itstep.FitnessClub.exception.ResourceNotFoundException;
import com.Itstep.FitnessClub.service.TrainingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * Отправка запросов на изменение расписания.
 */

@RestController
@RequestMapping("/api/trainings")
@RequiredArgsConstructor
public class TrainingController {

    private final TrainingService trainingService;

    @PostMapping("/create")
    public Training createTraining(TrainingChangeRequestDto training) {
        return trainingService.createTraining(training);
    }

    @PatchMapping("/change")
    public Training changeTraining(Long trainingId, TrainingChangeRequestDto trainingToChange) throws ResourceNotFoundException {
        return trainingService.changeSchedule(trainingId, trainingToChange);
    }

    @DeleteMapping("/delete")
    public void deleteTraining(Long trainingId) throws ResourceNotFoundException {
        trainingService.deleteTraining(trainingId);
    }

    @PostMapping("/createRoom")
    public Room createRoom(Room room) {
        return trainingService.createRoom(room);
    }

}
