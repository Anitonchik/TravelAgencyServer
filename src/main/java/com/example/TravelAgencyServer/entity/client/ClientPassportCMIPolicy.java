package com.example.TravelAgencyServer.entity.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class ClientPassportCMIPolicy {
    private Long id;

    private String firstName;

    private String lastName;

    private String surName;

    private LocalDateTime birthDate;

    private byte[] snils;

    private String email;

    private String phone;

    private String preferenceDescription;

    private Long passportId;

    private byte[] passportSeries;

    private byte[] passportNumbers;

    private byte[] passportImage;


    private Long policyId;

    private byte[] CMIPolicy;

    private byte[] policyImage;
}
