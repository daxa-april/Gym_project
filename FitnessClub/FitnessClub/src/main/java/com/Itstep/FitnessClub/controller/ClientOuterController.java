package com.Itstep.FitnessClub.controller;

import com.Itstep.FitnessClub.dto.request.ClientDto;
import com.Itstep.FitnessClub.exception.ResourceNotFoundException;
import com.Itstep.FitnessClub.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author Daria Pevets
 * <p>
 * Внешний контроллер для пользователей (регистрация + редактирование профиля)
 **/
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class ClientOuterController {

    private final ClientService clientService;

    @PostMapping("/add")
    public ClientDto createClient(ClientDto client) {
        return clientService.createNewClient(client);
    }

    @PatchMapping("/change")
    public ClientDto updateClient(Long clientId, ClientDto client) throws ResourceNotFoundException {
        return clientService.changeClient(clientId, client);
    }

    @DeleteMapping
    public void deleteClient(Long clientId) {
        clientService.deleteClient(clientId);
    }
}
