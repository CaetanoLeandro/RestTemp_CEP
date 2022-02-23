package com.resttempcep.exceptions.handler;


import com.resttempcep.exceptions.details.RestExceptionDetails;
import com.resttempcep.exceptions.notfound.NotFoundException;
import com.resttempcep.exceptions.timeover.StandardError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.time.Instant;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public RestExceptionDetails handlerNotFoundException(NotFoundException e) {
        return RestExceptionDetails.builder()
                .status(NOT_FOUND.value())
                .title("Not found")
                .timestamp(Instant.now())
                .details(e.getMessage())
                .developerMessage("Include a valid ID. Make sure it exists.")
                .build();
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<StandardError> handleResponseStatusException(ResponseStatusException e) {
        return ResponseEntity.status(e.getStatus())
                .headers(HttpHeaders.EMPTY)
                .body(StandardError.builder()
                        .status(e.getRawStatusCode())
                        .message(e.getMessage())
                        .build());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(BAD_REQUEST)
    public StandardError handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return StandardError.builder()
                .status(BAD_REQUEST.value())
                .message("You need to provide a shipping order to save!")
                .build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public StandardError handleGeneralExceptions(Exception e) {
        return StandardError.builder()
                .status(INTERNAL_SERVER_ERROR.value())
                .message(e.getMessage())
                .build();
    }


    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public StandardError handleRuntimeExceptions(RuntimeException e) {
        return StandardError.builder()
                .status(INTERNAL_SERVER_ERROR.value())
                .message("Unexpected Error!")
                .build();
    }

    @ExceptionHandler(IOException.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public StandardError handleIoExceptionExceptions(IOException e) {
        return StandardError.builder()
                .status(INTERNAL_SERVER_ERROR.value())
                .message("Input/Output error")
                .build();
    }
}
