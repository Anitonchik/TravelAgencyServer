package com.example.TravelAgencyServer.api.clientPassport;

public record ClientPassportRq(Long clientId, String series, String numbers, String image) {}
