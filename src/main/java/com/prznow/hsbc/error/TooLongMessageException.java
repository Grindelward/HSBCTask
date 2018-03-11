package com.prznow.hsbc.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class TooLongMessageException extends Exception {
    public TooLongMessageException() {
        super("Message length must be less than 140 characters");
    }
}
