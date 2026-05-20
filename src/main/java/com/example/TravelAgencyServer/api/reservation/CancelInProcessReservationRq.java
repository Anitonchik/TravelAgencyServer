package com.example.TravelAgencyServer.api.reservation;

import com.example.TravelAgencyServer.entity.reservation.InsuranceType;
import com.example.TravelAgencyServer.entity.reservation.PaymentType;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record CancelInProcessReservationRq(
        @NotBlank
        Long id,
        @NotBlank
        LocalDateTime reservationDate,
        @NotBlank
        LocalDateTime dateOfIssueOfTheVoucher,
        @NotBlank
        Long managerId,
        @NotBlank
        Long clientId,
        Long tourId,
        Long flightToId,
        Long flightFromId,
        Long hotelId,
        boolean indicateTransfer,
        boolean indicateInsurance,
        PaymentType paymentType,
        InsuranceType insuranceType) { }
