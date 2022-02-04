package com.example.resttempcep.v1.exceptions.handler;


import com.example.resttempcep.v1.exceptions.details.RestExceptionDetails;
import com.example.resttempcep.v1.exceptions.notfound.NotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public RestExceptionDetails handlerNotFoundException(NotFoundException e){
        return RestExceptionDetails.builder()
                .status(NOT_FOUND.value())
                .title("Not found")
                .timestamp(Instant.now())
                .details(e.getMessage())
                .developerMessage("Include a valid ID. Make sure it exists.")
                .build();

    }
}
