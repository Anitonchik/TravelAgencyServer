package com.example.TravelAgencyServer.api.clientPassport;

import com.example.TravelAgencyServer.api.client.ClientRs;

public record ClientPassportRs (Long id, ClientRs client, String series, String numbers, String image) {}
