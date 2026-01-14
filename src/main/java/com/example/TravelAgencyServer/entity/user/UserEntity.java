package com.example.TravelAgencyServer.entity.user;

import java.util.Date;

public class UserEntity {
    private Long id;
    private String firstName;
    private String lastName;
    private String surName;
    private UserRole userRole;
    private Date birthDate;
    private String email;
    private String phone;


    public UserEntity(Long id, String firstName, String lastName, String surName,
                        Date birthDate,  String email, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.surName = surName;
        this.userRole = UserRole.MANAGER;
        this.birthDate = birthDate;
        this.email = email;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
