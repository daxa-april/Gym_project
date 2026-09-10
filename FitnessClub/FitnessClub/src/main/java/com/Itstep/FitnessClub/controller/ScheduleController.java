package com.Itstep.FitnessClub.controller;

import com.Itstep.FitnessClub.dto.responce.TrainingResponceDto;
import com.Itstep.FitnessClub.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/*
 * Отправка запросов на вывод расписания.
 *
 */

@RestController
@RequestMapping("/api/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @GetMapping("/api/schedule")
    public List<TrainingResponceDto> getFullTrainingSchedule() {
        return scheduleService.getSchedule();
    }

    @GetMapping("/schedule/byDate")
    public List<TrainingResponceDto> getScheduleByDate(@RequestParam @DateTimeFormat
            (iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return scheduleService.getScheduleByDate(date);
    }

    @GetMapping("/schedule/byDateRange")
    public List<TrainingResponceDto> getScheduleByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) {
        return scheduleService.getScheduleByRange(from, to);
    }

    @GetMapping("/trainingName/{trainingName}")
    public List<TrainingResponceDto> getScheduleByTrainingName(@PathVariable String trainingName) {
        return scheduleService.getScheduleByTrainingName(trainingName);
    }
}
