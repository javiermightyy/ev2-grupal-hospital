package com.hospital.demo.exception;

import com.hospital.demo.dto.Response.apiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<apiResponse<Map<String, String>>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errores = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> 
            errores.put(error.getField(), error.getDefaultMessage()));

        apiResponse<Map<String, String>> response = new apiResponse<>(
                LocalDateTime.now(), 
                HttpStatus.BAD_REQUEST.value(), 
                "Error en los datos enviados", 
                errores
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourcesNotFoundException.class)
    public ResponseEntity<apiResponse<Void>> handleResourceNotFound(ResourcesNotFoundException ex) {
        apiResponse<Void> response = new apiResponse<>(
                LocalDateTime.now(), 
                HttpStatus.NOT_FOUND.value(), 
                ex.getMessage(), 
                null
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}