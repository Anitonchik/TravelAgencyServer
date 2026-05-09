package com.example.TravelAgencyServer.api.reservation;

public record VoucherRq(Long reservationId, boolean indicateTransfer, boolean indicateInsurance) { }
