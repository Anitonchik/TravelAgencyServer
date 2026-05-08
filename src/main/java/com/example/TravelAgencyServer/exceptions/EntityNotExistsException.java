package com.example.TravelAgencyServer.exceptions;

public class EntityNotExistsException extends RuntimeException {
    public EntityNotExistsException(Long id, String message) {
        super("entity with id = " +id + " not exists: \n" + message);
    }
}
