package com.moises.springboot.apirestful.controller;

import com.moises.springboot.apirestful.entities.Services;
import com.moises.springboot.apirestful.service.ServicesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/services")
public class ServicesController {

    private final ServicesService servicesService;

    public ServicesController(ServicesService servicesService) {
        this.servicesService = servicesService;
    }

    @GetMapping("/list")
    public List<Services> findAll() {
        return servicesService.findAll();
    }

    @GetMapping("/service/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Services> servicesOptional = servicesService.findById(id);

        if (servicesOptional.isPresent()) {
            return ResponseEntity.ok(servicesOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/create")
    public ResponseEntity<?> save(@RequestBody Services services) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servicesService.save(services));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Services> servicesOptional = servicesService.delete(id);

        if (servicesOptional.isPresent()) {
            return ResponseEntity.ok(servicesOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody Services services, @PathVariable Long id) {

        Optional<Services> servicesOptional = servicesService.update(id, services);

        if (servicesOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(servicesOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
