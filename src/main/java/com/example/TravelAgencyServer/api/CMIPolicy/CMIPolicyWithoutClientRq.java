package com.example.TravelAgencyServer.api.CMIPolicy;

import jakarta.validation.constraints.NotNull;

public record CMIPolicyWithoutClientRq(@NotNull String CMIPolicy, @NotNull String image) {
}
