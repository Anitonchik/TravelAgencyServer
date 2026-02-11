package com.example.TravelAgencyServer.entity.flight;

import com.example.TravelAgencyServer.entity.reservation.ReservationEntity;
import com.example.TravelAgencyServer.entity.tour.TourEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FlightEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="tour_id")
    private TourEntity tour;

    @ManyToOne
    @JoinColumn(name="reservation_id")
    private ReservationEntity reservation;

    @Column(nullable = false)
    private String airlineName;
    @Column(nullable = false)
    private String locationFrom;
    @Column(nullable = false)
    private String locationTo;
    @Column(nullable = false)
    private Date date;

    public FlightEntity(TourEntity tour, String airlineName, String locationFrom, String locationTo, Date date) {
        this.tour = tour;
        this.airlineName = airlineName;
        this.locationFrom = locationFrom;
        this.locationTo = locationTo;
        this.date = date;
    }
}
