package com.example.TravelAgencyServer.api.tour;

import com.example.TravelAgencyServer.entity.tour.TourIntensity;
import com.example.TravelAgencyServer.entity.tour.TourType;

import java.util.Date;

public record TourRq(String name, String direction, String description, String duration, int numberOfSeats,
                     Double price, Date dateFrom, Date dateTo, Boolean isTransferExists,
                     Boolean isInsurancesExists, TourType tourType, TourIntensity tourIntensity) {
}
