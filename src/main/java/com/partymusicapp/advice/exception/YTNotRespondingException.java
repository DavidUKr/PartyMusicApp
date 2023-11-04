package com.partymusicapp.advice.exception;

public class YTNotRespondingException extends RuntimeException {
    public YTNotRespondingException(String message){
        super(message);
    }
}
