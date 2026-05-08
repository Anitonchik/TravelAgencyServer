package com.example.TravelAgencyServer.api.reservation;

import com.example.TravelAgencyServer.entity.reservation.PaymentType;
import com.example.TravelAgencyServer.entity.reservation.Status;
import jakarta.validation.constraints.NotBlank;

public record ReservationRq(
        @NotBlank
        Long managerId,
        @NotBlank
        Long clientId,
        @NotBlank
        Long tourId,
        @NotBlank
        Long flightToId,
        @NotBlank
        Long flightFromId,
        @NotBlank
        Long hotelId,
        @NotBlank
        boolean indicateTransfer,
        @NotBlank
        boolean indicateInsurance,
        @NotBlank
        Status status,
        @NotBlank
        PaymentType paymentType) {}
