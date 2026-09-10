package com.Itstep.FitnessClub.mapper;

import com.Itstep.FitnessClub.dto.responce.TrainingResponceDto;
import com.Itstep.FitnessClub.entity.Training;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-09-10T12:48:37+0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class TrainingMapperImpl implements TrainingMapper {

    @Override
    public TrainingResponceDto trainingtoTrainingResponceDto(Training training) {
        if ( training == null ) {
            return null;
        }

        LocalDateTime trainingStart = null;
        String trainerName = null;
        int bookedCount = 0;

        trainingStart = training.getTrainingStart();
        trainerName = training.getTrainerName();
        bookedCount = training.getBookedCount();

        String trainingName = null;
        String roomName = null;

        TrainingResponceDto trainingResponceDto = new TrainingResponceDto( trainingName, trainingStart, trainerName, roomName, bookedCount );

        return trainingResponceDto;
    }
}
