package com.example.TravelAgencyServer.api.reservation;

import com.example.TravelAgencyServer.entity.reservation.InsuranceType;
import com.example.TravelAgencyServer.entity.reservation.PaymentType;
import com.example.TravelAgencyServer.entity.reservation.Status;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record ReservationRq(
        @NotBlank
        LocalDateTime reservationDate,
        LocalDateTime dateOfIssueOfTheVoucher,
        @NotBlank
        Long managerId,
        @NotBlank
        Long clientId,
        @NotBlank
        Long tourId,
        Long flightToId,
        Long flightFromId,
        Long hotelId,
        @NotBlank
        boolean indicateTransfer,
        @NotBlank
        boolean indicateInsurance,
        @NotBlank
        Status status,
        @NotBlank
        PaymentType paymentType,

        InsuranceType insuranceType) {}
