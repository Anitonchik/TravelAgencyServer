package com.example.TravelAgencyServer.entity.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class ClientPassportCMIPolicy {
    private Long id;

    private String firstName;

    private String lastName;

    private String surName;

    private Date birthDate;

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
