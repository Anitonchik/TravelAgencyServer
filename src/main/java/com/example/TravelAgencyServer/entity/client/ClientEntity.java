package com.example.TravelAgencyServer.entity.client;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String surName;
    @Column(nullable = false)
    private Date birthDate;
    @Column(nullable = false)
    private byte[] snils;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private String phone;
    @Column
    private String preferenceDescription;
    @Column(nullable = false)
    private boolean isDeleted;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<ClientPassportEntity> passports = new ArrayList<>();

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<CMIPolicyEntity> CMIPolicies = new ArrayList<>();

    public ClientEntity(String firstName, String lastName, String surName, Date birthDate, byte[] snils, String email, String phone, String preferenceDescription) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.surName = surName;
        this.birthDate = birthDate;
        this.snils = snils;
        this.email = email;
        this.phone = phone;
        this.preferenceDescription = preferenceDescription;
        this.isDeleted = false;
    }
}
