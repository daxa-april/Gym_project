package com.Itstep.FitnessClub.controller;

import com.Itstep.FitnessClub.dto.response.ClientInnerResponseDto;
import com.Itstep.FitnessClub.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Кабинет фитнес центра", description = "Внутрениий поиск и изменение подписок")
public class ClientInnerController {

    private final ClientService clientService;

    @Operation(summary = "Изменить абонемент")
    @PatchMapping("/subscriptionUpdate")
    public ClientInnerResponseDto updateClientSubscription(Long clientId, int trainingsLeft) {
        return clientService.updateClientSubscriptionInfo(clientId, trainingsLeft);
    }
    @Operation(summary = "Поиск абонемента по имени пользователя")
    @GetMapping("/searchByName")
    public ClientInnerResponseDto findByFullName(String fullName) {
        return clientService.findByFullName(fullName);
    }

    @Operation(summary = "Поиск абонемента по номеру телефона")
    @GetMapping("/searchByNumber")
    public ClientInnerResponseDto findByPhone(String number) {
        return clientService.findByPhone(number);
    }
}
