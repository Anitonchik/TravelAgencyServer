package com.example.TravelAgencyServer.api.reservation;

import com.example.TravelAgencyServer.api.client.ClientRs;
import com.example.TravelAgencyServer.api.flight.FlightRs;
import com.example.TravelAgencyServer.api.hotel.HotelRs;
import com.example.TravelAgencyServer.api.manager.ManagerRs;
import com.example.TravelAgencyServer.api.tour.TourRs;
import com.example.TravelAgencyServer.entity.reservation.PaymentType;
import com.example.TravelAgencyServer.entity.reservation.Status;


public record ReservationRs (Long id, ClientRs client, ManagerRs manager, TourRs tour,
                             FlightRs flightTo, FlightRs flightFrom, HotelRs hotel, Status status,
                             PaymentType paymentType) {}
