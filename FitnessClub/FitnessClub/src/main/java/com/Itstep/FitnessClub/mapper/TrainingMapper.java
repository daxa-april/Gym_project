package com.Itstep.FitnessClub.mapper;

import com.Itstep.FitnessClub.dto.responce.TrainingResponceDto;
import com.Itstep.FitnessClub.entity.Training;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Daria Pevets
 **/
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TrainingMapper {

    TrainingResponceDto trainingtoTrainingResponceDto(Training training);
}
