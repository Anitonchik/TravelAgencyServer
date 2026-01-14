package com.example.TravelAgencyServer.entity.reservation;

import com.example.TravelAgencyServer.entity.client.ClientEntity;
import com.example.TravelAgencyServer.entity.flight.FlightEntity;
import com.example.TravelAgencyServer.entity.hotel.HotelEntity;
import com.example.TravelAgencyServer.entity.tour.TourEntity;
import com.example.TravelAgencyServer.entity.transfer.TransferEntity;
import com.example.TravelAgencyServer.entity.user.UserEntity;
import jakarta.persistence.*;

@Entity
public class ReservationEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private ClientEntity client;

    @ManyToOne
    @JoinColumn(name = "tour_id", nullable = false)
    private TourEntity tour;

    @ManyToOne
    @JoinColumn(name = "flight_from", nullable = false)
    private FlightEntity flightFrom;

    @ManyToOne
    @JoinColumn(name = "flight_to", nullable = false)
    private FlightEntity flightTo;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private HotelEntity hotel;

    @ManyToOne
    @JoinColumn(name = "transfer_hotel_to", nullable = false)
    private TransferEntity transferToHotel;

    @ManyToOne
    @JoinColumn(name = "transfer_hotel_from", nullable = false)
    private TransferEntity transferFromHotel;

    private StatusEntity status;

    public ReservationEntity(){}

    public ReservationEntity(Long id, UserEntity user, ClientEntity client, TourEntity tour, FlightEntity flightFrom, FlightEntity flightTo, HotelEntity hotel, TransferEntity transferToHotel, TransferEntity transferFromHotel, StatusEntity status) {
        this.id = id;
        this.user = user;
        this.client = client;
        this.tour = tour;
        this.flightFrom = flightFrom;
        this.flightTo = flightTo;
        this.hotel = hotel;
        this.transferToHotel = transferToHotel;
        this.transferFromHotel = transferFromHotel;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public TourEntity getTour() {
        return tour;
    }

    public void setTour(TourEntity tour) {
        this.tour = tour;
    }

    public FlightEntity getFlightFrom() {
        return flightFrom;
    }

    public void setFlightFrom(FlightEntity flightFrom) {
        this.flightFrom = flightFrom;
    }

    public FlightEntity getFlightTo() {
        return flightTo;
    }

    public void setFlightTo(FlightEntity flightTo) {
        this.flightTo = flightTo;
    }

    public HotelEntity getHotel() {
        return hotel;
    }

    public void setHotel(HotelEntity hotel) {
        this.hotel = hotel;
    }

    public TransferEntity getTransferToHotel() {
        return transferToHotel;
    }

    public void setTransferToHotel(TransferEntity transferToHotel) {
        this.transferToHotel = transferToHotel;
    }

    public TransferEntity getTransferFromHotel() {
        return transferFromHotel;
    }

    public void setTransferFromHotel(TransferEntity transferFromHotel) {
        this.transferFromHotel = transferFromHotel;
    }

    public StatusEntity getStatus() {
        return status;
    }

    public void setStatus(StatusEntity status) {
        this.status = status;
    }
}

