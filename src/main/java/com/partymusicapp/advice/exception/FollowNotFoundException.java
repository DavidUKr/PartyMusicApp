package com.partymusicapp.advice.exception;

public class FollowNotFoundException extends RuntimeException{

    public FollowNotFoundException(String message){
        super(message);
    }
}
