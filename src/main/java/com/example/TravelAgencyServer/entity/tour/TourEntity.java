package com.example.TravelAgencyServer.entity.tour;

import com.example.TravelAgencyServer.entity.flight.FlightEntity;
import com.example.TravelAgencyServer.entity.hotel.HotelEntity;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class TourEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String direction;
    private String description;
    private String duration;
    private int numberOfSeats;
    private Double price;
    private Date dateFrom;
    private Date dateTo;
    private Boolean isTransferExists;
    private Boolean isInsurancesExists;
    private TourType tourType;
    private TourIntensity tourIntensity;

    @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL)
    private List<FlightEntity> tourFlights;

    @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL)
    private List<HotelEntity> tourHotels;
}
