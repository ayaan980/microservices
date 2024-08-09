package com.micro.user.UserService.exception;

public class ResourceNotFoundException extends RuntimeException{

    public  ResourceNotFoundException(){
        super("Resource not found exception");
    }
}
