package com.example.TravelAgencyServer.api.tour;

import com.example.TravelAgencyServer.entity.tour.TourCity;
import com.example.TravelAgencyServer.entity.tour.TourIntensity;
import com.example.TravelAgencyServer.entity.tour.TourType;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public record TourRq(
        @NotBlank
        @Size(min = 6, max = 255)
        String name,
        @NotBlank
        @Size (min = 6, max = 255)
        TourCity direction,
        @NotBlank
        String description,
        @NotBlank
        String duration,
        @NotBlank
        @Min(10)
        @Max(50)
        int numberOfSeats,
        @NotBlank
        Double price,
        @NotBlank
        @Future
        LocalDate dateFrom,
        @NotBlank
        @Future
        LocalDate dateTo,
        @NotBlank
        Boolean isTransferExists,
        @NotBlank
        Boolean isInsurancesExists,
        @NotBlank
        TourType tourType,
        @NotBlank
        TourIntensity tourIntensity,
        @NotBlank
        String image) {
}
