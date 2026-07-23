package com.Itstep.FitnessClub.controller;

import com.Itstep.FitnessClub.dto.responce.TrainingResponceDto;
import com.Itstep.FitnessClub.service.ScheduleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Отправка запросов на вывод расписания.
 */

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/api/schedule")
    public List <TrainingResponceDto> getTrainingSchedule() {
        return scheduleService.getSchedule();
    }

}
