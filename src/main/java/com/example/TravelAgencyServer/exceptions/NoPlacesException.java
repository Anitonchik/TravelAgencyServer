package com.example.TravelAgencyServer.exceptions;

public class NoPlacesException extends RuntimeException {
    public NoPlacesException(Long id){
        super("нет мест в свмолете под id = " + id);
    }
}
