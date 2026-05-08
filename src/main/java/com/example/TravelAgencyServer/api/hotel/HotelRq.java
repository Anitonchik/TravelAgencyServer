package com.example.TravelAgencyServer.api.hotel;

import com.example.TravelAgencyServer.entity.hotel.FoodType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record HotelRq (
        @NotBlank
        @Size(min = 6, max = 255)
        String name,
        @NotBlank
        @Size (min = 6, max = 255)
        int durationOfStay,
        @NotBlank
        @Min(10)
        @Max(50)
        int numberOfPlacesInTheRoom,
        @NotBlank
        Double price,
        @NotBlank
        String location,
        @NotBlank
        String image,
        @NotBlank
        FoodType foodType) { }
