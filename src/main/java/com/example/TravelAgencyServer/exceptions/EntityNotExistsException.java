package com.example.TravelAgencyServer.exceptions;

public class EntityNotExistsException extends RuntimeException {
    public EntityNotExistsException(Long id) {
        super("entity with id = ${id} not exists");
    }
}
