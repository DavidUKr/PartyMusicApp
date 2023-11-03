package com.partymusicapp.advice.exception;

public class YoutubeSearchListEmptyException extends RuntimeException {
    public YoutubeSearchListEmptyException(String message) {
        super(message);
    }
}
