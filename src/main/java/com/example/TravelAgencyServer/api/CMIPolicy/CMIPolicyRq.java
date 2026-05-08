package com.example.TravelAgencyServer.api.CMIPolicy;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CMIPolicyRq (
        @NotBlank
        Long clientId,
        @NotBlank
        @Size(min = 16, max = 16)
        String CMIPolicy,
        @NotBlank
        String image) { }
