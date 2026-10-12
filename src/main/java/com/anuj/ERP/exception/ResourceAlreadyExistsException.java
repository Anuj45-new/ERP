package com.anuj.ERP.exception;

public class ResourceAlreadyExistsException extends RuntimeException{
    public ResourceAlreadyExistsException(String Message){
        super(Message);
    }
}
