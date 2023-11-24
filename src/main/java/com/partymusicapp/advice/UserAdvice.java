package com.partymusicapp.advice;

import com.partymusicapp.advice.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class UserAdvice {

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String userNotFoundHandler(UserNotFoundException e){
        return e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(PartyNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String partyNotFoundHandler(PartyNotFoundException e){
        return e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(FollowNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String followNotFoundHandler(FollowNotFoundException e){
        return e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(YoutubeSearchListEmptyException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String songListEmptyHandler(YoutubeSearchListEmptyException e){
        return e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(YTNotRespondingException.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    String ytNotRespondingHandler(YTNotRespondingException e){
        return e.getMessage();
    }
}
