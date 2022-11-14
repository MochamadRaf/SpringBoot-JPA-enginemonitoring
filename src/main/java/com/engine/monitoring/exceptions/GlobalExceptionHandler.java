package com.engine.monitoring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InternalServerError.class)
    public ResponseEntity<ErrorMessage>
    internalServerError(Exception ex, WebRequest request) {
        ErrorMessage errors =
                new ErrorMessage(500, new Date(), ex.getMessage(), "Internal Server Error");
        return new ResponseEntity<>(errors, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<ErrorMessage>
    userNotFound(Exception ex, WebRequest request) {
        ErrorMessage errors =
                new ErrorMessage(404, new Date(), ex.getMessage(), "Server Not Found");

        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }
}
