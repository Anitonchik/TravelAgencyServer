package com.example.TravelAgencyServer.entity.transfer;

import com.example.TravelAgencyServer.entity.tour.TourEntity;
import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;

@Entity
public class TransferEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "tour_id")
    private TourEntity tour;

    private Date date;
    private Time time;
    private Double price;

    public TransferEntity() {
    }

    public TransferEntity(Long id, String name, TourEntity tour, Date date, Time time, Double price) {
        this.id = id;
        this.name = name;
        this.tour = tour;
        this.date = date;
        this.time = time;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TourEntity getTour() {
        return tour;
    }

    public void setTour(TourEntity tour) {
        this.tour = tour;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
