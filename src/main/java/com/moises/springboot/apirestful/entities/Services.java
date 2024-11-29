package com.moises.springboot.apirestful.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Services {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 0, max = 100)
    private String name;

    @NotBlank
    @Size(min = 0, max = 250)
    private String description;


    @NotNull
    @Min(5000)
    @Max(100000)
    private Integer price;
}
