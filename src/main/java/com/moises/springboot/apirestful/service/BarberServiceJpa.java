package com.moises.springboot.apirestful.service;

import com.moises.springboot.apirestful.repositories.BarberRepository;
import org.springframework.stereotype.Service;

@Service
public class BarberServiceJpa implements BarberService {

    private final BarberRepository barberRepository;

    public BarberServiceJpa(BarberRepository barberRepository) {
        this.barberRepository = barberRepository;
    }
}
