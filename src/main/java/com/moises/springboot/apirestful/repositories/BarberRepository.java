package com.moises.springboot.apirestful.repositories;

import com.moises.springboot.apirestful.entities.Barber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarberRepository extends JpaRepository<Barber, Long> {
}
