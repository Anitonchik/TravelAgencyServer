package com.example.TravelAgencyServer.api.clientPassport;

import jakarta.validation.constraints.NotNull;

public record ClientPassportWithoutClientRq(@NotNull String series,@NotNull String numbers,@NotNull String image)  {}
