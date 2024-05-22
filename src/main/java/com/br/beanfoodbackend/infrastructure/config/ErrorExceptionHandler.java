package com.br.beanfoodbackend.infrastructure.config;

import com.br.beanfoodbackend.infrastructure.exception.NotFoundException;
import com.br.beanfoodbackend.infrastructure.exception.RecordAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ErrorExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = { Exception.class })
    public ResponseEntity<?> handleAnyException(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = { RecordAlreadyExistsException.class })
    public ResponseEntity<?> recordAlreadyExists(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = { NotFoundException.class })
    public ResponseEntity<?> notFoundException(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
    }
}
