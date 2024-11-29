package com.moises.springboot.apirestful.service;

import com.moises.springboot.apirestful.repositories.AppointmentRepository;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceJpa implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentServiceJpa(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }
}
