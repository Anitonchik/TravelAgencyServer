package com.example.TravelAgencyServer.api.client;

import com.example.TravelAgencyServer.api.CMIPolicy.CMIPolicyRs;
import com.example.TravelAgencyServer.api.clientPassport.ClientPassportRs;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class ClientRs {
    private Long id;
    private String firstName;
    private String lastName;
    private String surName;
    private Date birthDate;
    private String snils;
    private String email;
    private String phone;
    private String preferenceDescription;
    private ClientPassportRs passport;
    private CMIPolicyRs policy;
}
