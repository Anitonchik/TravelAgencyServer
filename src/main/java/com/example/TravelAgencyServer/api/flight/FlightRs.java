package com.example.TravelAgencyServer.api.flight;

import java.time.LocalDateTime;
import java.util.Date;

public record FlightRs (Long id, String airlineName, String locationFrom,
                        String locationTo, LocalDateTime date, Double price, int countOfSeats) {}
