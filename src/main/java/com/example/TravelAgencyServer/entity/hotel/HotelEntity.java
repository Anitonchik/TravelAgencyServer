package com.example.TravelAgencyServer.entity.hotel;

import com.example.TravelAgencyServer.entity.tour.TourEntity;
import com.example.TravelAgencyServer.entity.transfer.TransferEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

@Entity
public class HotelEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tour_id")
    private TourEntity tour;

    @NotEmpty
    private String name;
    @NotEmpty
    private int durationOfStay;
    @NotEmpty
    private int numberOfPlacesInTheRoom;
    @NotEmpty
    private Double price;
    @NotEmpty
    private String location;
    @NotEmpty
    private String image;

    @NotEmpty
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "hotel_food_types",
            joinColumns = { @JoinColumn(name = "hotel_id") },
            inverseJoinColumns = { @JoinColumn(name = "food_type_id") })
    private List<FoodTypeEntity> foodTypes;

    @NotEmpty
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "hotel_transfer",
            joinColumns = { @JoinColumn(name = "hotel_id") },
            inverseJoinColumns = { @JoinColumn(name = "transfer_id") })
    private List<TransferEntity> transfers;


    public HotelEntity() {}

    public HotelEntity(Long id, TourEntity tour, String name, int durationOfStay, int numberOfPlacesInTheRoom,
            Double price, String location, String image, List<FoodTypeEntity> foodTypes, List<TransferEntity> transfers
    ) {
        this.id = id;
        this.tour = tour;
        this.name = name;
        this.durationOfStay = durationOfStay;
        this.numberOfPlacesInTheRoom = numberOfPlacesInTheRoom;
        this.price = price;
        this.location = location;
        this.image = image;
        this.foodTypes = foodTypes;
        this.transfers = transfers;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDurationOfStay() {
        return durationOfStay;
    }

    public void setDurationOfStay(int durationOfStay) {
        this.durationOfStay = durationOfStay;
    }

    public int getNumberOfPlacesInTheRoom() {
        return numberOfPlacesInTheRoom;
    }

    public void setNumberOfPlacesInTheRoom(int numberOfPlacesInTheRoom) {
        this.numberOfPlacesInTheRoom = numberOfPlacesInTheRoom;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<FoodTypeEntity> getFoodTypes() {
        return foodTypes;
    }

    public void setFoodTypes(List<FoodTypeEntity> foodTypes) {
        this.foodTypes = foodTypes;
    }

    public List<TransferEntity> getTransfers() {
        return transfers;
    }

    public void setTransfers(List<TransferEntity> transfers) {
        this.transfers = transfers;
    }
}
