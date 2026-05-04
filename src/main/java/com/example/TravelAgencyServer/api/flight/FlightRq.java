package com.example.TravelAgencyServer.api.flight;

import java.util.Date;

public record FlightRq (String airlineName, String locationFrom, String locationTo, Date date) {
}
