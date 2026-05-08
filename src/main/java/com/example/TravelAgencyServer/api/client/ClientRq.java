package com.example.TravelAgencyServer.api.client;

import jakarta.validation.constraints.*;

import java.util.Date;

public record ClientRq (
        @NotBlank(message = "Имя обязательно")
        @Size(min = 2, max = 255, message = "Имя должно быть от 2 до 255 символов")
        String firstName,

        @NotBlank (message = "Отчество обязательно")
        @Size (min = 2, max = 255, message = "Фамилия должна быть от 2 до 255 символов")
        String lastName,

        @NotBlank (message = "Отчество обязательна")
        @Size (min = 2, max = 255, message = "Отчество должно быть от 2 до 255 символов")
        String surName,

        @NotBlank (message = "Дата обязательна")
        @Past(message = "Дата рождения должна быть в прошлом")
        Date birthDate,

        @NotBlank (message = "СНИЛС обязателен")
        @Size (min = 16, max = 16, message = "СНИЛС должен содержать 16 символов")
        String snils,

        @NotBlank (message = "email обязателен")
        @Size (min = 6, max = 255, message = "Длина email должна быть от 6 до 255 символов")
        @Pattern(regexp = "^[a-zA-Z0-9][a-zA-Z0-9._-]*@[a-zA-Z0-9][a-zA-Z0-9.-]*\\.[a-zA-Z]{2,}$", message = "Некорректный формат почты")
        String email,

        @NotBlank (message = "телефон обязателен")
        @Pattern (regexp = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$", message = "Некотрректный формат номера телефона")
        String phone,

        @Size (max = 2048, message = "Описание должно быть не больше 2048 символов")
        String preferenceDescription,

        @NotBlank
        @Size (min = 4, max = 4)
        String passportSeries,

        @NotBlank
        @Size (min = 6, max = 6)
        String passportNumbers,

        @NotBlank
        String passportImage,

        @NotBlank
        @Size (min = 16, max = 16)
        String policy,

        @NotBlank
        String policyImage) {
}
