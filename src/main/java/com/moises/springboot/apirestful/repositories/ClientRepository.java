package com.moises.springboot.apirestful.repositories;

import com.moises.springboot.apirestful.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
