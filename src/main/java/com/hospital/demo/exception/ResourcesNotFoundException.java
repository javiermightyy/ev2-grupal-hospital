package com.hospital.demo.exception;

public class ResourcesNotFoundException extends RuntimeException {
    
    public ResourcesNotFoundException(String message) {
        super(message);
    }
}