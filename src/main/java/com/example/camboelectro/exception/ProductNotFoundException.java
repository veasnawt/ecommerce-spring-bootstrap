package com.example.camboelectro.exception;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    // ...
}
