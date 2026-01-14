package com.example.TravelAgencyServer.entity.tour;

import com.example.TravelAgencyServer.entity.flight.FlightEntity;
import com.example.TravelAgencyServer.entity.hotel.HotelEntity;
import com.example.TravelAgencyServer.entity.insurance.InsuranceEntity;
import com.example.TravelAgencyServer.entity.transfer.TransferEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class TourEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String direction;
    private String description;
    private String duration;
    private int numberOfSeats;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "tour_type_id")
    private TourTypeEntity tourType;

    @ManyToOne
    @JoinColumn(name="tour_intensity_id")
    private TourIntensityEntity tourIntensity;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "tour_id")
    private List<TourDateEntity> tourDates;

    @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL)
    private List<FlightEntity> tourFlights;

    @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL)
    private List<HotelEntity> tourHotels;

    @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL)
    private List<TransferEntity> tourTransfers;

    @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL)
    private List<InsuranceEntity> tourInsurances;

    public TourEntity() {}

    public TourEntity(Long id, String name, String direction, String description, String duration,
                      int numberOfSeats, Double price, TourIntensityEntity tourIntensity) {
        this.id = id;
        this.name = name;
        this.direction = direction;
        this.description = description;
        this.duration = duration;
        this.numberOfSeats = numberOfSeats;
        this.price = price;
        this.tourIntensity = tourIntensity;
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

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public TourIntensityEntity getTourIntensity() {
        return tourIntensity;
    }

    public void setTourIntensity(TourIntensityEntity tourIntensity) {
        this.tourIntensity = tourIntensity;
    }

    public List<TourDateEntity> getTourDates() {
        return tourDates;
    }

    public void setTourDates(List<TourDateEntity> tourDates) {
        this.tourDates = tourDates;
    }

    public List<FlightEntity> getFlights() {
        return tourFlights;
    }

    public void setFlights(List<FlightEntity> tourFlights) {
        this.tourFlights = tourFlights;
    }

    public List<HotelEntity> getHotels() {
        return tourHotels;
    }

    public void setHotels(List<HotelEntity> tourHotels) {
        this.tourHotels = tourHotels;
    }

    public List<TransferEntity> getTransfers() {
        return tourTransfers;
    }

    public void setTransfers(List<TransferEntity> tourTransfers) {
        this.tourTransfers = tourTransfers;
    }

    public List<InsuranceEntity> getInsurances() {
        return tourInsurances;
    }

    public void setInsurances(List<InsuranceEntity> tourInsurances) {
        this.tourInsurances = tourInsurances;
    }
}
