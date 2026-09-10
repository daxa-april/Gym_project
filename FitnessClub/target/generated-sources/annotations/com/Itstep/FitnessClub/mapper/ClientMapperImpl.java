package com.Itstep.FitnessClub.mapper;

import com.Itstep.FitnessClub.dto.request.ClientDto;
import com.Itstep.FitnessClub.dto.response.ClientInnerResponseDto;
import com.Itstep.FitnessClub.entity.Client;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-09-10T16:56:10+0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public ClientDto clientToClientDto(Client client) {
        if ( client == null ) {
            return null;
        }

        String fullName = null;
        String email = null;
        String phone = null;

        fullName = client.getFullName();
        email = client.getEmail();
        phone = client.getPhone();

        ClientDto clientDto = new ClientDto( fullName, email, phone );

        return clientDto;
    }

    @Override
    public ClientInnerResponseDto clientToClientInnerResponceDto(Client client) {
        if ( client == null ) {
            return null;
        }

        String fullName = null;
        String email = null;
        String phone = null;

        fullName = client.getFullName();
        email = client.getEmail();
        phone = client.getPhone();

        Long clientId = null;

        ClientInnerResponseDto clientInnerResponseDto = new ClientInnerResponseDto( clientId, fullName, email, phone );

        return clientInnerResponseDto;
    }
}
