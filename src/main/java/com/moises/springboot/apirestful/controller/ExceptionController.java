package com.moises.springboot.apirestful.controller;

import com.moises.springboot.apirestful.entities.ErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Date;

@RestControllerAdvice
public class ExceptionController {

    // 400 INGRESO DE STRING EN ID, INGRESO ID CON ESPACIO
    @ExceptionHandler({MethodArgumentTypeMismatchException.class, MissingPathVariableException.class})
    public ResponseEntity<ErrorException> TypeMismatchMissingPath(Exception ex) {

        ErrorException exception = new ErrorException();
        exception.setFecha(new Date());
        exception.setMensaje(ex.getMessage());
        exception.setEstatus(HttpStatus.BAD_REQUEST.value());
        if (ex instanceof MethodArgumentTypeMismatchException) {
            exception.setError("El id no puede estar compuesto de caracteres!");
        } else if (ex instanceof MissingPathVariableException) {
            exception.setError("El id no puede contener espacios vacíos");
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception);
    }

    // 404 ID SIN PARAMETROS
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorException> noHandlerFound(NoHandlerFoundException ex) {

        ErrorException exception = new ErrorException();
        exception.setFecha(new Date());
        exception.setError("Debes pasar parametros al id!");
        exception.setMensaje(ex.getMessage());
        exception.setEstatus(HttpStatus.NOT_FOUND.value());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception);
    }

    // 500 ID IGUAL O MENOR A 0, NULL
    @ExceptionHandler({IllegalArgumentException.class, NullPointerException.class})
    public ResponseEntity<ErrorException> illegalArgumentOrNullPointer(Exception ex) {
        ErrorException exception = new ErrorException();
        exception.setFecha(new Date());
        exception.setMensaje(ex.getMessage());
        exception.setEstatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        if (ex instanceof IllegalArgumentException) {
            exception.setError("El id ingresado no puede ser menor o igual a 0!");
        } else if (ex instanceof NullPointerException) {
            exception.setError("El id ingresado no existe!");
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception);
    }

/*
    @ExceptionHandler({NoHandlerFoundException.class, IdNotFound.class})
    public ResponseEntity<ErrorException> handlerNoFound(Exception ex) {
        ErrorException exception = new ErrorException();
        exception.setFecha(new Date());
        exception.setError("Recurso no encontrado!");
        exception.setMensaje(ex.getMessage());
        exception.setEstatus(HttpStatus.NOT_FOUND.value());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception);
    }
     */
}
