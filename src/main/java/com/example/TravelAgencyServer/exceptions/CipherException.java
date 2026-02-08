package com.example.TravelAgencyServer.exceptions;

public class CipherException extends RuntimeException{
    public CipherException (String message, Throwable ex) {
        super(message, ex);
    }
}
