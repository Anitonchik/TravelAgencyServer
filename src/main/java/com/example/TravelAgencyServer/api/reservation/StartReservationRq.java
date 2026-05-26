package com.example.TravelAgencyServer.api.reservation;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.Date;

public record StartReservationRq (
    @NotBlank
    Date reservationDate,
    @NotBlank
    Long managerId,
    @NotBlank
    Long clientId,
    @NotBlank
    Long tourId
    ) {}
