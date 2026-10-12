package com.anuj.ERP.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFound(ResourceNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<String> handleResourceExists(ResourceAlreadyExistsException re){
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(re.getMessage());
    }

    // @Valid exception handler(if wrong data/format entered)
    // Pre-built

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidation(
            MethodArgumentNotValidException ex) {

        // we want to return JSON form of key-value pair like Name:Must not be blank; so will convert that data to map
        Map<String, String> errors = new HashMap<>();

        // another class that has info about validation, it doesn't perform validation, validation has already taken place
        // It retrieves result after validation
        ex.getBindingResult()
                // method to get list about field validated e.g. fieldError1-> f = name, mssg = "Must not be blanked"
                .getFieldErrors()
                .forEach(error ->
                        errors.put(
                                error.getField(),
                                error.getDefaultMessage()
                        )
                );

        // Newly created class to send error in well-structured and design pattern

        ApiError response = new ApiError(
                HttpStatus.BAD_REQUEST.value(),
                "Validation failed",
                errors
        );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

}