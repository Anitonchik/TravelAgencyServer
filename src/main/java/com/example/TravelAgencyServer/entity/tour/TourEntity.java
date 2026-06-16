package com.example.TravelAgencyServer.entity.tour;

import com.example.TravelAgencyServer.entity.flight.FlightEntity;
import com.example.TravelAgencyServer.entity.hotel.HotelEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
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
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TourCity direction;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String duration;
    @Column(nullable = false)
    private int numberOfSeats;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
    private LocalDateTime dateFrom;
    @Column(nullable = false)
    private LocalDateTime dateTo;
    @Column(nullable = false)
    private Boolean isTransferExists;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TourType tourType;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TourIntensity tourIntensity;
    @Column(nullable = false, length = 1500)
    private String image;

    @ManyToMany
    @JoinTable(name="tour_flight",
            joinColumns=  @JoinColumn(name="tour_id", referencedColumnName="id"),
            inverseJoinColumns= @JoinColumn(name="flight_id", referencedColumnName="id") )
    private List<FlightEntity> flights;

    @ManyToMany
    @JoinTable(name="tour_hotel",
            joinColumns=  @JoinColumn(name="tour_id", referencedColumnName="id"),
            inverseJoinColumns= @JoinColumn(name="hotel_id", referencedColumnName="id") )
    private List<HotelEntity> hotels;

    public TourEntity(String name, TourCity direction, String description, String duration, int numberOfSeats, Double price,
                      LocalDateTime dateFrom, LocalDateTime dateTo, Boolean isTransferExists, TourType tourType,
                      TourIntensity tourIntensity, String image, List<FlightEntity> flights, List<HotelEntity> hotels) {
        this.name = name;
        this.direction = direction;
        this.description = description;
        this.duration = duration;
        this.numberOfSeats = numberOfSeats;
        this.price = price;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.isTransferExists = isTransferExists;
        this.tourType = tourType;
        this.tourIntensity = tourIntensity;
        this.image = image;
        this.flights = flights;
        this.hotels = hotels;
    }
}
