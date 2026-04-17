package org.example.sgsejercicio.handler;

import jakarta.persistence.EntityNotFoundException;
import org.example.sgsejercicio.errors.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class handlerExeption {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> validateNotFound(EntityNotFoundException ex){
        return new ResponseEntity<>(new ErrorResponse("No se encontro tu entidad, "+ex.getMessage(), HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> validateInput(MethodArgumentNotValidException ex){
        return new ResponseEntity<>(new ErrorResponse("Input no valido, "+ex.getBindingResult().getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
    }
}