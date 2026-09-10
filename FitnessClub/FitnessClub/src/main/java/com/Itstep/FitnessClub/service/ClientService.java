package com.Itstep.FitnessClub.service;

import com.Itstep.FitnessClub.dto.request.ClientDto;
import com.Itstep.FitnessClub.dto.responce.ClientInnerResponceDto;
import com.Itstep.FitnessClub.entity.Client;
import com.Itstep.FitnessClub.entity.Subscription;
import com.Itstep.FitnessClub.exception.ResourceNotFoundException;
import com.Itstep.FitnessClub.mapper.ClientMapper;
import com.Itstep.FitnessClub.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Daria Pevets
 **/
@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientDto createNewClient(ClientDto client) {
        Client newClient = new Client();
        newClient.setPhone(client.phone());
        newClient.setEmail(client.email());
        newClient.setFullName(client.fullName());
        clientRepository.save(newClient);
        return clientMapper.clientToClientDto(newClient);
    }

    public void deleteClient(Long clientId) {
        if (clientRepository.existsById(clientId)) {
            clientRepository.deleteById(clientId);
        } else {
            throw new ResourceNotFoundException("Client with id " + clientId + " not found");
        }
    }

    public ClientDto changeClient(Long clientId, ClientDto client) {
        if (clientRepository.findById(clientId).isPresent()) {
            Client clientToChange = clientRepository.findById(clientId).get();
            clientToChange.setId(clientId);
            clientToChange.setFullName(client.fullName());
            clientToChange.setEmail(client.email());
            clientToChange.setPhone(client.phone());
            clientRepository.save(clientToChange);
            return clientMapper.clientToClientDto(clientToChange);
        } else {
            throw new ResourceNotFoundException("Client not found");
        }
    }

    public ClientInnerResponceDto updateClientSubscriptionInfo(Long clientId, int trainingsLeftCount) {
        if (clientRepository.findById(clientId).isPresent()) {
            Subscription subscriptionToChange = clientRepository.findById(clientId).get().getSubscription();
            subscriptionToChange.setTrainingsLeft(trainingsLeftCount);
        } else {
            throw new ResourceNotFoundException("Client not found");
        }
        return clientMapper.clientToClientInnerResponceDto(clientRepository.findById(clientId).get());
    }

    public ClientInnerResponceDto findByFullName(String fullName) {
        return clientMapper.clientToClientInnerResponceDto(clientRepository.findByFullName(fullName));

    }

    public ClientInnerResponceDto findByPhone(String number) {
        return clientMapper.clientToClientInnerResponceDto(clientRepository.findByPhone(number));
    }
}
