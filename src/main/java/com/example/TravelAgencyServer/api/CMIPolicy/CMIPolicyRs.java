package com.example.TravelAgencyServer.api.CMIPolicy;

import com.example.TravelAgencyServer.api.client.ClientRs;

public record CMIPolicyRs(Long id, ClientRs client, String CMIPolicy, String image) { }
