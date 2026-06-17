package com.example.TravelAgencyServer.api.manager;

import java.time.LocalDateTime;
import java.util.Date;

public record ManagerRs(Long id, String firstName, String lastName, String surName,
                        LocalDateTime birthDate, String email, String login,
                        String password) { }
