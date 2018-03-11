package com.prznow.hsbc.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CannotFindUserException extends Exception {
    public CannotFindUserException(String username) {
        super("Cannot find user with name: " + username);
    }

    public CannotFindUserException(Integer id) {
        super("Cannot find user with id: " + id);
    }
}
