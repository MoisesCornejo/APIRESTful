package com.moises.springboot.apirestful.service;

import com.moises.springboot.apirestful.entities.Services;
import com.moises.springboot.apirestful.repositories.ServicesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ServicesServiceJpa implements ServicesService {

    private final ServicesRepository servicesRepository;

    public ServicesServiceJpa(ServicesRepository servicesRepository) {
        this.servicesRepository = servicesRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Services> findAll() {
        return servicesRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Services> findById(Long id) {
        return servicesRepository.findById(id);
    }

    @Transactional
    @Override
    public Services save(Services services) {
        return servicesRepository.save(services);
    }

    @Transactional
    @Override
    public Optional<Services> delete(Long id) {
        Optional<Services> servicesOptional = servicesRepository.findById(id);
        servicesOptional.ifPresent(servicesRepository::delete);
        return servicesOptional;
    }

    @Transactional
    @Override
    public Optional<Services> update(Long id, Services services) {
        Optional<Services> servicesOptional = findById(id);

        if (servicesOptional.isPresent()) {
            Services s = servicesOptional.orElseThrow();

            s.setName(services.getName());
            s.setDescription(services.getDescription());
            s.setPrice(services.getPrice());

            return Optional.of(servicesRepository.save(s));
        }

        return servicesOptional;
    }
}
