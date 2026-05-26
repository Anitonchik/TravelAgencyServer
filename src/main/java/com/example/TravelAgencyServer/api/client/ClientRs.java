package com.example.TravelAgencyServer.api.client;

import com.example.TravelAgencyServer.api.CMIPolicy.CMIPolicyRs;
import com.example.TravelAgencyServer.api.clientPassport.ClientPassportRs;
import com.example.TravelAgencyServer.entity.tour.TourCity;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
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
    private TourCity preferenceCity;
    private Date preferenceDateFrom;
    private Double preferencePriceFrom;
    private Double preferencePriceTo;
    private ClientPassportRs passport;
    private CMIPolicyRs policy;
}
