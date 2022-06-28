package com.example.demo;

public class NoRollbackException extends RuntimeException {

    public NoRollbackException(String message) {
        super(message);
    }
}
