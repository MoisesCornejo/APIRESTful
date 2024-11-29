package com.moises.springboot.apirestful.controller;

import com.moises.springboot.apirestful.entities.Services;
import com.moises.springboot.apirestful.service.ServicesService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public ResponseEntity<?> save(@Valid @RequestBody Services services,
                                  BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return validation(bindingResult);
        }

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
    public ResponseEntity<?> update(@Valid @RequestBody Services services,
                                    BindingResult bindingResult,
                                    @PathVariable Long id) {

        if (bindingResult.hasFieldErrors()) {
            return validation(bindingResult);
        }

        Optional<Services> servicesOptional = servicesService.update(id, services);

        if (servicesOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(servicesOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    private ResponseEntity<?> validation(BindingResult bindingResult) {
        Map<String, String> errors = new HashMap<>();

        bindingResult.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }
}
