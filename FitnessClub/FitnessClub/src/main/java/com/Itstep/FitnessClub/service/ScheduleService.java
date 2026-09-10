package com.Itstep.FitnessClub.service;

import com.Itstep.FitnessClub.data.TrainingType;
import com.Itstep.FitnessClub.dto.responce.TrainingResponceDto;
import com.Itstep.FitnessClub.entity.Training;
import com.Itstep.FitnessClub.mapper.TrainingMapper;
import com.Itstep.FitnessClub.repository.TrainingRepositoryInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * вывод расписания.
 */
@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final TrainingRepositoryInterface trainingRepository;
    private final TrainingMapper trainingMapper;

    public List<TrainingResponceDto> getSchedule() {
        List<Training> trainings = trainingRepository.findAll();
        return trainings.stream()
                .map(trainingMapper::trainingtoTrainingResponceDto)
                .collect(Collectors.toList());
    }

    public List<TrainingResponceDto> getScheduleByDate(LocalDate date) {
        return getScheduleByRange(date, date);
    }

    public List<TrainingResponceDto> getScheduleByRange(LocalDate start, LocalDate end) {
        if (start.isAfter(end)) {
            throw new IllegalArgumentException("Start date cannot be after end date");
        }
        LocalDateTime from = start.atStartOfDay();
        LocalDateTime to = end.plusDays(1).atStartOfDay(); // the end of the day is included
        return trainingRepository.findByTrainingStart(from, to).stream()
                .map(trainingMapper::trainingtoTrainingResponceDto)
                .collect(Collectors.toList());
    }

    public List<TrainingResponceDto> getScheduleByTrainingName(String trainingName) {
        TrainingType trainingToSearch = TrainingType.valueOf(trainingName);
        return trainingRepository.findByTrainingType(trainingToSearch).stream()
                .map(trainingMapper::trainingtoTrainingResponceDto)
                .collect(Collectors.toList());
    }


}
