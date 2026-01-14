package com.example.TravelAgencyServer.entity.insurance;

import com.example.TravelAgencyServer.entity.tour.TourEntity;
import jakarta.persistence.*;

@Entity
public class InsuranceEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "tour_id")
    private TourEntity tour;


    public InsuranceEntity() {}

    public InsuranceEntity(Long id, String name, String description, TourEntity tour) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.tour = tour;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TourEntity getTour() {
        return tour;
    }

    public void setTour(TourEntity tour) {
        this.tour = tour;
    }
}
