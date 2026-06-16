package com.example.TravelAgencyServer.api.tour;

import com.example.TravelAgencyServer.api.flight.FlightRs;
import com.example.TravelAgencyServer.api.hotel.HotelRs;
import com.example.TravelAgencyServer.entity.tour.TourCity;
import com.example.TravelAgencyServer.entity.tour.TourIntensity;
import com.example.TravelAgencyServer.entity.tour.TourType;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public record TourRs(Long id, String name, TourCity direction, String description, String duration, int numberOfSeats,
                     Double price, LocalDateTime dateFrom, LocalDateTime dateTo, Boolean isTransferExists,
                     Boolean isInsurancesExists, TourType tourType, TourIntensity tourIntensity, String image,
                     List<FlightRs> flightsTo, List<FlightRs> flightsFrom, List<HotelRs> hotels) {}
