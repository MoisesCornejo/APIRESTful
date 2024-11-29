package com.moises.springboot.apirestful.service;

import com.moises.springboot.apirestful.entities.Services;

import java.util.List;
import java.util.Optional;

public interface ServicesService {

    List<Services> findAll();
    Optional<Services> findById(Long id);
    Services save(Services services);
    Optional<Services> delete(Long id);
    Optional<Services> update(Long id, Services services);

}
