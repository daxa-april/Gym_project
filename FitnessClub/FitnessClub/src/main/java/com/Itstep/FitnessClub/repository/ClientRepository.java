package com.Itstep.FitnessClub.repository;

import com.Itstep.FitnessClub.entity.Client;

import java.util.List;

public class ClientRepository {

    List<Client> clients;

    public ClientRepository(List<Client> clients) {
        this.clients = clients;
    }
}
