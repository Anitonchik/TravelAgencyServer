package com.example.TravelAgencyServer.api.client;

import com.example.TravelAgencyServer.entity.client.CMIPolicyEntity;
import com.example.TravelAgencyServer.entity.client.ClientEntity;
import com.example.TravelAgencyServer.entity.client.ClientPassportEntity;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class ClientPassportCMIPolicyEntity {
    private Long id;

    private String firstName;

    private String lastName;

    private String surName;

    private Date birthDate;

    private byte[] snils;

    private String email;

    private String phone;

    private String preferenceDescription;

    private ClientPassportEntity passport;

    private CMIPolicyEntity policy;

    /*public ClientPassportCMIPolicyEntity (ClientEntity clientEntity,
                                          ClientPassportEntity passport, CMIPolicyEntity policy){
        this.id = clientEntity.getId();
        this.firstName = clientEntity.getFirstName();
        this.lastName = clientEntity.getLastName();
        this.surName = clientEntity.getSurName();
        this.birthDate = clientEntity.getBirthDate();
        this.email = clientEntity.getEmail();
        this.phone = clientEntity.getPhone();
        this.preferenceDescription = clientEntity.getPreferenceDescription();
    }*/
}
