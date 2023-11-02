package com.partymusicapp.advice.exception;

public class PartyNotFoundException extends RuntimeException {
    public PartyNotFoundException(String message) {
        super(message);
    }
}
