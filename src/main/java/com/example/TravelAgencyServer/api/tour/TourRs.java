package com.example.TravelAgencyServer.api.tour;

import com.example.TravelAgencyServer.api.flight.FlightRs;
import com.example.TravelAgencyServer.api.hotel.HotelRs;
import com.example.TravelAgencyServer.entity.tour.TourIntensity;
import com.example.TravelAgencyServer.entity.tour.TourType;

import java.util.Date;
import java.util.List;

public record TourRs(Long id, String name, String direction, String description, String duration, int numberOfSeats,
                     Double price, Date dateFrom, Date dateTo, Boolean isTransferExists,
                     Boolean isInsurancesExists, TourType tourType, TourIntensity tourIntensity,
                     List<FlightRs> flightsTo, List<FlightRs> flightsFrom, List<HotelRs> hotels) {}
