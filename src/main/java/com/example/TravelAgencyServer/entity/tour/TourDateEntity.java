package com.example.TravelAgencyServer.entity.tour;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class TourDateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;

    public TourDateEntity() {}

    public TourDateEntity(Long id, Date date) {
        this.id = id;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
