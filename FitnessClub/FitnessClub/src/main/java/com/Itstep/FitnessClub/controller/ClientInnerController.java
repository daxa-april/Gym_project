package com.Itstep.FitnessClub.controller;

import com.Itstep.FitnessClub.dto.responce.ClientInnerResponceDto;
import com.Itstep.FitnessClub.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Daria Pevets
 * <p>
 * Внутренний контроллер для работников фитнес-клуба.
 **/
@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientInnerController {

    private final ClientService clientService;

    @PatchMapping("/subscriptionUpdate")
    public ClientInnerResponceDto updateClientSubscription(Long clientId, int trainingsLeft) {
        return clientService.updateClientSubscriptionInfo(clientId, trainingsLeft);
    }

    @GetMapping("/searchByName")
    public ClientInnerResponceDto findByFullName(String fullName) {
        return clientService.findByFullName(fullName);
    }

    @GetMapping("/searchByNumber")
    public ClientInnerResponceDto findByPhone(String number) {
        return clientService.findByPhone(number);
    }
}
