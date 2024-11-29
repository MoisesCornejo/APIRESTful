package com.moises.springboot.apirestful.service;

import com.moises.springboot.apirestful.repositories.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceJpa implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceJpa(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
}
