package com.example.TravelAgencyServer.entity.client;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String surName;
    private Date birthDate;
    private byte[] snils;
    private String email;
    private String phone;
    private String preferenceDescription;

    public ClientEntity(String firstName, String lastName, String surName, Date birthDate, byte[] snils, String email, String phone, String preferenceDescription) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.surName = surName;
        this.birthDate = birthDate;
        this.snils = snils;
        this.email = email;
        this.phone = phone;
        this.preferenceDescription = preferenceDescription;
    }
}
