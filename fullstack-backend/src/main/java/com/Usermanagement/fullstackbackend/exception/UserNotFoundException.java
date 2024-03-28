package com.Usermanagement.fullstackbackend.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id){
        super("Could not Founf the user with id "+ id);
    }
}
