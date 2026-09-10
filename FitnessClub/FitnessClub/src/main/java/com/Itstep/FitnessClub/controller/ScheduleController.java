package com.Itstep.FitnessClub.controller;

import com.Itstep.FitnessClub.dto.response.TrainingResponseDto;
import com.Itstep.FitnessClub.service.ScheduleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Внутренний сервис расписания", description = "вывод и сортировка расписания")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @Operation(summary = "Без фильтров")
    @GetMapping("/api/schedule")
    public List<TrainingResponseDto> getFullTrainingSchedule() {
        return scheduleService.getSchedule();
    }

    @Operation(summary = "По дате")
    @GetMapping("/schedule/byDate")
    public List<TrainingResponseDto> getScheduleByDate(@RequestParam @DateTimeFormat
            (iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return scheduleService.getScheduleByDate(date);
    }

    @Operation(summary = "По диапазону дат")
    @GetMapping("/schedule/byDateRange")
    public List<TrainingResponseDto> getScheduleByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) {
        return scheduleService.getScheduleByRange(from, to);
    }

    @Operation(summary = "По виду тренировок")
    @GetMapping("/trainingName/{trainingName}")
    public List<TrainingResponseDto> getScheduleByTrainingName(@PathVariable String trainingName) {
        return scheduleService.getScheduleByTrainingName(trainingName);
    }
}
