package com.example.TravelAgencyServer.api.tour;

import com.example.TravelAgencyServer.entity.tour.TourIntensity;
import com.example.TravelAgencyServer.entity.tour.TourType;
import jakarta.validation.constraints.*;

import java.util.Date;

public record TourRq(
        @NotBlank
        @Size(min = 6, max = 255)
        String name,
        @NotBlank
        @Size (min = 6, max = 255)
        String direction,
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
        Date dateFrom,
        @NotBlank
        @Future
        Date dateTo,
        @NotBlank
        Boolean isTransferExists,
        @NotBlank
        Boolean isInsurancesExists,
        @NotBlank
        TourType tourType,
        @NotBlank
        TourIntensity tourIntensity) {
}
