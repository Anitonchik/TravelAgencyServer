package com.example.TravelAgencyServer.entity.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
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
    private UserRole userRole;
    @Column(nullable = false)
    private Date birthDate;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
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
