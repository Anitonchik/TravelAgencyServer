package com.example.TravelAgencyServer.entity.tour;

import com.example.TravelAgencyServer.entity.flight.FlightEntity;
import com.example.TravelAgencyServer.entity.hotel.HotelEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TourEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(nullable = false)
    private String direction;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String duration;
    @Column(nullable = false)
    private int numberOfSeats;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
    private Date dateFrom;
    @Column(nullable = false)
    private Date dateTo;
    @Column(nullable = false)
    private Boolean isTransferExists;
    @Column(nullable = false)
    private Boolean isInsurancesExists;
    @Column(nullable = false)
    private TourType tourType;
    @Column(nullable = false)
    private TourIntensity tourIntensity;

    @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL)
    private List<FlightEntity> tourFlights;

    @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL)
    private List<HotelEntity> tourHotels;

    public TourEntity(String name, String direction, String description, String duration, int numberOfSeats, Double price,
                      Date dateFrom, Date dateTo, Boolean isTransferExists, Boolean isInsurancesExists, TourType tourType,
                      TourIntensity tourIntensity, List<FlightEntity> tourFlights, List<HotelEntity> tourHotels) {
        this.name = name;
        this.direction = direction;
        this.description = description;
        this.duration = duration;
        this.numberOfSeats = numberOfSeats;
        this.price = price;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.isTransferExists = isTransferExists;
        this.isInsurancesExists = isInsurancesExists;
        this.tourType = tourType;
        this.tourIntensity = tourIntensity;
        this.tourFlights = tourFlights;
        this.tourHotels = tourHotels;
    }
}
