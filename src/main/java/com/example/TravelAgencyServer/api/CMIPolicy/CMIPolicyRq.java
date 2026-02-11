package com.example.TravelAgencyServer.api.CMIPolicy;

import jakarta.validation.constraints.NotNull;

public record CMIPolicyRq (@NotNull Long clientId,@NotNull String CMIPolicy,@NotNull String image) { }
