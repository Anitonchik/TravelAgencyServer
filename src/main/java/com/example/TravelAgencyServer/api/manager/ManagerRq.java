package com.example.TravelAgencyServer.api.manager;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Date;

public record ManagerRq(
        @NotBlank
        @Size(min = 2, max = 255)
        String firstName,
        @NotBlank
        @Size(min = 2, max = 255)
        String lastName,
        @NotBlank
        @Size(min = 2, max = 255)
        String surName,
        @NotBlank
        @Past(message = "дата рождения должна быть в прошлом")
        Date birthDate,
        @NotBlank
        @Size (min = 6, max = 255, message = "длина email должна быть от 6 до 255 символов")
        @Pattern(regexp = "^[a-zA-Z0-9][a-zA-Z0-9._-]*@[a-zA-Z0-9][a-zA-Z0-9.-]*\\.[a-zA-Z]{2,}$")
        String email,
        @NotBlank
        @Size (min = 6, max = 20)
        String login,
        @NotBlank
        @Size(min = 6, max = 12)
        String password) {}
