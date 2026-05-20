package com.example.TravelAgencyServer.exceptions;

public class InvalidLoginException extends RuntimeException {
    public InvalidLoginException(String login){
        super("Пользователя с логином " + login + " не существует");
    }
}
