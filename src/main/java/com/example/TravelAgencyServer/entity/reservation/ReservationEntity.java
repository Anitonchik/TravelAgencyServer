package com.example.TravelAgencyServer.entity.reservation;

import com.example.TravelAgencyServer.entity.client.ClientEntity;
import com.example.TravelAgencyServer.entity.flight.FlightEntity;
import com.example.TravelAgencyServer.entity.hotel.HotelEntity;
import com.example.TravelAgencyServer.entity.tour.TourEntity;
import com.example.TravelAgencyServer.entity.manager.ManagerEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ReservationEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "manager_id", nullable = false)
    private ManagerEntity manager;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private ClientEntity client;

    @ManyToOne
    @JoinColumn(name = "tour_id", nullable = false)
    private TourEntity tour;

    @ManyToOne
    @JoinColumn(name = "flight_to_id")
    private FlightEntity flightTo;

    @ManyToOne
    @JoinColumn(name = "flight_from_id")
    private FlightEntity flightFrom;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private HotelEntity hotel;

    @Enumerated(EnumType.STRING)
    @Column
    private Status status;

    @Enumerated(EnumType.STRING)
    @Column
    private PaymentType paymentType;

    public ReservationEntity(ManagerEntity manager, ClientEntity client, TourEntity tour,
                             FlightEntity flightTo, FlightEntity flightFrom, HotelEntity hotel,
                             Status status, PaymentType paymentType) {
        this.manager = manager;
        this.client = client;
        this.tour = tour;
        this.flightTo = flightTo;
        this.flightFrom = flightFrom;
        this.hotel = hotel;
        this.status = status;
        this.paymentType = paymentType;
    }
}

