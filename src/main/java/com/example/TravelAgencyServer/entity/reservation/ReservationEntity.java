package com.example.TravelAgencyServer.entity.reservation;

import com.example.TravelAgencyServer.entity.client.ClientEntity;
import com.example.TravelAgencyServer.entity.flight.FlightEntity;
import com.example.TravelAgencyServer.entity.hotel.HotelEntity;
import com.example.TravelAgencyServer.entity.tour.TourEntity;
import com.example.TravelAgencyServer.entity.user.UserEntity;
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
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private ClientEntity client;

    @ManyToOne
    @JoinColumn(name = "tour_id", nullable = false)
    private TourEntity tour;

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
    private List<FlightEntity> flights;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private HotelEntity hotel;

    @Enumerated(EnumType.STRING)
    @Column
    private Status status;

    public ReservationEntity(UserEntity user, ClientEntity client, TourEntity tour, List<FlightEntity> flights, HotelEntity hotel, Status status) {
        this.user = user;
        this.client = client;
        this.tour = tour;
        this.flights = flights;
        this.hotel = hotel;
        this.status = status;
    }
}

