package com.example.TravelAgencyServer.entity.flight;

import com.example.TravelAgencyServer.entity.tour.TourEntity;
import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;

@Entity
public class FlightEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="tour_id")
    private TourEntity tour;
    private String airlineName;
    private String locationFrom;
    private String locationTo;
    private Date date;
    private Time time;


    public FlightEntity() {
    }

    public FlightEntity(Long id, TourEntity tour, String airlineName, String locationFrom, String locationTo, Date date, Time time) {
        this.id = id;
        this.tour = tour;
        this.airlineName = airlineName;
        this.locationFrom = locationFrom;
        this.locationTo = locationTo;
        this.date = date;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TourEntity getTour() {
        return tour;
    }

    public void setTour(TourEntity tour) {
        this.tour = tour;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getLocationFrom() {
        return locationFrom;
    }

    public void setLocationFrom(String locationFrom) {
        this.locationFrom = locationFrom;
    }

    public String getLocationTo() {
        return locationTo;
    }

    public void setLocationTo(String locationTo) {
        this.locationTo = locationTo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }



}
