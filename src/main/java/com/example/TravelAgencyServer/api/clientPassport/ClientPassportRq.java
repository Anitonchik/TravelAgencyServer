package com.example.TravelAgencyServer.api.clientPassport;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ClientPassportRq(
        @NotBlank
        Long clientId,
        @NotBlank
        @Size(min = 4, max = 4)
        String series,
        @NotBlank
        @Size (min = 6, max = 6)
        String numbers,
        @NotBlank
        String image) {}
