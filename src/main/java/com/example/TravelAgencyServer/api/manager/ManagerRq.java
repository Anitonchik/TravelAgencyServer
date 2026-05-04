package com.example.TravelAgencyServer.api.manager;

import java.util.Date;

public record ManagerRq(String firstName, String lastName, String surName,
                        Date birthDate, String email, String phone) {}
