package com.examserver.helper;

public class UserNotFoundException extends Exception {

    public UserNotFoundException() {
        super("User with this username not found in data base");
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
