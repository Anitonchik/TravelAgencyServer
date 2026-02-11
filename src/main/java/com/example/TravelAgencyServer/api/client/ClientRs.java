package com.example.TravelAgencyServer.api.client;

import lombok.Builder;

import java.util.Date;

@Builder
public record ClientRs (String firstName, String lastName, String surName,
                        Date birthDate, String snils, String email, String phone, String preferenceDescription) {
}
