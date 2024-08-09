package com.micro.hotel.HotelService.exception;

public class NoReferenceFound extends RuntimeException{

    public NoReferenceFound(String s){
        super(s);
    }

    public NoReferenceFound(){
        super("Resource not found");
    }

}
