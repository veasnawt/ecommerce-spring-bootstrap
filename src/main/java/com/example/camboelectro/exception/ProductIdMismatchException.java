package com.example.camboelectro.exception;

public class ProductIdMismatchException extends RuntimeException {
    public ProductIdMismatchException(String message, Throwable cause) {
        super(message, cause);
    }
    // ...
}
