package com.moises.springboot.apirestful.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ErrorException {

    private String mensaje;
    private String error;
    private int estatus;
    private Date fecha;

}
