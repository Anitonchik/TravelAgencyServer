package com.example.TravelAgencyServer.api.reservation;

public record ReservationRq(Long userId, Long clientId, Long tourId) {}
