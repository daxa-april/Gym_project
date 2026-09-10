package com.Itstep.FitnessClub.mapper;


import com.Itstep.FitnessClub.dto.request.ClientDto;
import com.Itstep.FitnessClub.dto.response.ClientInnerResponseDto;
import com.Itstep.FitnessClub.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Daria Pevets
 **/
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ClientMapper {

    ClientDto clientToClientDto(Client client);

    ClientInnerResponseDto clientToClientInnerResponceDto(Client client);

}
