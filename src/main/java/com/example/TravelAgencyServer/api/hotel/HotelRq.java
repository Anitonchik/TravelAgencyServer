package com.example.TravelAgencyServer.api.hotel;

import com.example.TravelAgencyServer.entity.hotel.FoodType;

public record HotelRq (Long tourId, String name, int durationOfStay, int numberOfPlacesInTheRoom,
                       Double price, String location, String image, FoodType foodType) { }
