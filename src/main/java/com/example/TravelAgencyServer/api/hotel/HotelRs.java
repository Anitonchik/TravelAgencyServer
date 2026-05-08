package com.example.TravelAgencyServer.api.hotel;

import com.example.TravelAgencyServer.api.tour.TourRs;
import com.example.TravelAgencyServer.entity.hotel.FoodType;

public record HotelRs (Long id, String name, int durationOfStay, int numberOfPlacesInTheRoom,
                       Double price, String location, String image, FoodType foodType) { }
