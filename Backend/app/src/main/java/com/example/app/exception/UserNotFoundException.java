package com.example.app.exception;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(long id) {
        super(String.format("user is not found with id : '%s'", id));
    }
    public UserNotFoundException(String username) {
        super(String.format("user is not found with id : '%s'", username));
    }
}
