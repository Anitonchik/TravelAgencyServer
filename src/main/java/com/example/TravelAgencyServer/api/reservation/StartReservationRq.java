package com.example.TravelAgencyServer.api.reservation;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record StartReservationRq (
    @NotBlank
    LocalDateTime reservationDate,
    @NotBlank
    Long managerId,
    @NotBlank
    Long clientId,
    @NotBlank
    Long tourId
    ) {}
