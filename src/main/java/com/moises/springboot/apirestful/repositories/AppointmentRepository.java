package com.moises.springboot.apirestful.repositories;

import com.moises.springboot.apirestful.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
