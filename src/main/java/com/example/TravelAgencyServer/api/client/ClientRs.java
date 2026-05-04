package com.example.TravelAgencyServer.api.client;

import com.example.TravelAgencyServer.api.CMIPolicy.CMIPolicyRs;
import com.example.TravelAgencyServer.api.clientPassport.ClientPassportRs;
import lombok.Builder;

import java.util.Date;

@Builder
public record ClientRs (
        String firstName,
        String lastName,
        String surName,
        Date birthDate,
        String snils,
        String email,
        String phone,
        String preferenceDescription,
        ClientPassportRs passport,
        CMIPolicyRs policy) {
}
