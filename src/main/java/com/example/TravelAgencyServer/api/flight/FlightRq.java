package com.example.TravelAgencyServer.api.flight;

import com.example.TravelAgencyServer.entity.flight.AirlineName;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public record FlightRq (
        @NotBlank
        AirlineName airlineName,
        @NotBlank
        String locationFrom,
        @NotBlank
        String locationTo,
        @NotBlank
        LocalDate date,
        @NotBlank
        int countOfSeats) {
}
