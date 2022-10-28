package com.examserver.helper;

import org.springframework.http.ResponseEntity;

public class UserFoundException extends Exception {

    public UserFoundException() {
        super("User with this username is already in data base, try with another one");
    }

    public UserFoundException(String message) {
        super(message);
    }

    public UserFoundException(ResponseEntity<?> exceptionHandler) {
    }
}
