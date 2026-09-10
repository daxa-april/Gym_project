package com.Itstep.FitnessClub.controller;

import com.Itstep.FitnessClub.dto.request.TrainingChangeRequestDto;
import com.Itstep.FitnessClub.entity.Room;
import com.Itstep.FitnessClub.entity.Training;
import com.Itstep.FitnessClub.exception.ResourceNotFoundException;
import com.Itstep.FitnessClub.service.TrainingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * Отправка запросов на изменение расписания.
 */

@RestController
@RequestMapping("/api/trainings")
@RequiredArgsConstructor
@Tag(name = "Внутренний сервис тренировок", description = "создание и изменение тренировок и залов")
public class TrainingController {

    private final TrainingService trainingService;

    @Operation(summary = "Создание тренировки")
    @PostMapping("/create")
    public Training createTraining(TrainingChangeRequestDto training) {
        return trainingService.createTraining(training);
    }

    @Operation(summary = "Изменение тренировки")
    @PatchMapping("/change")
    public Training changeTraining(Long trainingId, TrainingChangeRequestDto trainingToChange) throws ResourceNotFoundException {
        return trainingService.changeSchedule(trainingId, trainingToChange);
    }

    @Operation(summary = "Удаление тренировки")
    @DeleteMapping("/delete")
    public void deleteTraining(Long trainingId) throws ResourceNotFoundException {
        trainingService.deleteTraining(trainingId);
    }

    @Operation(summary = "Создание спортивного зала")
    @PostMapping("/createRoom")
    public Room createRoom(Room room) {
        return trainingService.createRoom(room);
    }

}
