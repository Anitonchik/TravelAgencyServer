package com.example.TravelAgencyServer.api.client;

import java.util.Date;

public record ClientRq (String firstName, String lastName, String surName,
        Date birthDate, String snils, String email, String phone, String preferenceDescription) {
}
