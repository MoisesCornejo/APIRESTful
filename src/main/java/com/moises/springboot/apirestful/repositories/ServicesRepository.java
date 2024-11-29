package com.moises.springboot.apirestful.repositories;

import com.moises.springboot.apirestful.entities.Services;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicesRepository extends JpaRepository<Services, Long> {
}
