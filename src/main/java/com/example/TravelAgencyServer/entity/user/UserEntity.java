package com.example.TravelAgencyServer.entity.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String surName;
    private UserRole userRole;
    private Date birthDate;
    private String email;
    private String phone;

    public UserEntity(String firstName, String lastName, String surName, Date birthDate, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.surName = surName;
        this.userRole = UserRole.MANAGER;
        this.birthDate = birthDate;
        this.email = email;
        this.phone = phone;
    }
}
