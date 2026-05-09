package com.example.TravelAgencyServer.entity.flight;

import com.example.TravelAgencyServer.entity.reservation.ReservationEntity;
import com.example.TravelAgencyServer.entity.tour.TourEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FlightEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String airlineName;
    @Column(nullable = false)
    private String locationFrom;
    @Column(nullable = false)
    private String locationTo;
    @Column(nullable = false)
    private Date date;
    @Column(nullable = false)
    private Double price;
    @Column
    private int countOfSeats;

    @OneToMany(mappedBy="flightTo", fetch = FetchType.LAZY)
    private List<ReservationEntity> reservationsTo = new ArrayList<>();

    @OneToMany(mappedBy="flightFrom", fetch = FetchType.LAZY)
    private List<ReservationEntity> reservationsFrom = new ArrayList<>();

    public FlightEntity(String airlineName, String locationFrom, String locationTo,
                        Date date, Double price, int countOfSeats) {
        this.airlineName = airlineName;
        this.locationFrom = locationFrom;
        this.locationTo = locationTo;
        this.date = date;
        this.price = price;
        this.countOfSeats = countOfSeats;
    }
}
