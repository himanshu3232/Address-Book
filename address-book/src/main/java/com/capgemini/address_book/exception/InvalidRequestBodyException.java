package com.capgemini.address_book.exception;

public class InvalidRequestBodyException extends RuntimeException{
    public InvalidRequestBodyException(String message){
        super(message);
    }
}
