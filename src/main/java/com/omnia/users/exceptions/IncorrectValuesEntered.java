package com.omnia.users.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.FORBIDDEN;

@ResponseStatus(FORBIDDEN)
public class IncorrectValuesEntered extends RuntimeException {

    public IncorrectValuesEntered(String message) {
        super(message);
    }
}
