package com.example.TravelAgencyServer.api.flight;

import java.util.Date;

public record FlightRs (Long id, String airlineName, String locationFrom,
                        String locationTo, Date date) {}
