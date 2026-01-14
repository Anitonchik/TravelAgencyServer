package com.example.TravelAgencyServer.entity.client;

import com.example.TravelAgencyServer.entity.tour.TourIntensityEntity;
import com.example.TravelAgencyServer.entity.tour.TourTypeEntity;
import jakarta.persistence.*;

@Entity
public class PreferenceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private ClientEntity client;

    @OneToOne
    @JoinColumn(name = "tour_type_id", referencedColumnName = "id")
    private TourTypeEntity tourType;

    @OneToOne
    @JoinColumn(name = "intensity_id", referencedColumnName = "id")
    private TourIntensityEntity tourIntensityEntity;

    private int durationOfTrips;
    private Double PriceRangeFrom;
    private Double PriceRangeUpTo;


    public PreferenceEntity() {}

    public PreferenceEntity(Long id, ClientEntity client, TourTypeEntity tourType, TourIntensityEntity tourIntensityEntity, int durationOfTrips, Double PriceRangeFrom, Double PriceRangeUpTo) {
        this.id = id;
        this.client = client;
        this.tourType = tourType;
        this.tourIntensityEntity = tourIntensityEntity;
        this.durationOfTrips = durationOfTrips;
        this.PriceRangeFrom = PriceRangeFrom;
        this.PriceRangeUpTo = PriceRangeUpTo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public TourTypeEntity getTourType() {
        return tourType;
    }

    public void setTourType(TourTypeEntity tourType) {
        this.tourType = tourType;
    }

    public TourIntensityEntity getTourIntensityEntity() {
        return tourIntensityEntity;
    }

    public void setTourIntensityEntity(TourIntensityEntity tourIntensityEntity) {
        this.tourIntensityEntity = tourIntensityEntity;
    }

    public int getDurationOfTrips() {
        return durationOfTrips;
    }

    public void setDurationOfTrips(int durationOfTrips) {
        this.durationOfTrips = durationOfTrips;
    }

    public Double getPriceRangeFrom() {
        return PriceRangeFrom;
    }

    public void setPriceRangeFrom(Double PriceRangeFrom) {
        this.PriceRangeFrom = PriceRangeFrom;
    }

    public Double getPriceRangeUpTo() {
        return PriceRangeUpTo;
    }

    public void setPriceRangeUpTo(Double PriceRangeUpTo) {
        this.PriceRangeUpTo = PriceRangeUpTo;
    }
}
