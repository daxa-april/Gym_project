package com.Itstep.FitnessClub.controller;

import com.Itstep.FitnessClub.dto.request.TrainingChangeRequestDto;
import com.Itstep.FitnessClub.entity.Training;
import com.Itstep.FitnessClub.exception.TrainingNotFoundException;
import com.Itstep.FitnessClub.service.TrainingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Отправка запросов на изменение расписания.
 */

@RestController
@RequestMapping("/api/trainings")
public class TrainingController {

    private final TrainingService trainingService;

    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @PostMapping("/api/trainings/create")
    public Training createTraining(TrainingChangeRequestDto training) throws TrainingNotFoundException {
        return trainingService.createTraining(training);
    }
    //todo: добавить удаление и обновление.
}
