package com.example.TravelAgencyServer.api.client;

import com.example.TravelAgencyServer.entity.client.CMIPolicyEntity;
import com.example.TravelAgencyServer.entity.client.ClientPassportEntity;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class ClientPassportCMIPolicyEntity {
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
