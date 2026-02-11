package com.example.TravelAgencyServer.entity.hotel;

import com.example.TravelAgencyServer.entity.tour.TourEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class HotelEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "tour_id")
    private TourEntity tour;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int durationOfStay;
    @Column(nullable = false)
    private int numberOfPlacesInTheRoom;
    @Column(nullable = false)
    private Double price;
    @Column(unique = true, nullable = false)
    private String location;
    @Column(nullable = false)
    private String image;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FoodType foodType;

    public HotelEntity(TourEntity tour, String name, int durationOfStay, int numberOfPlacesInTheRoom, Double price,
                       String location, String image, FoodType foodType) {
        this.tour = tour;
        this.name = name;
        this.durationOfStay = durationOfStay;
        this.numberOfPlacesInTheRoom = numberOfPlacesInTheRoom;
        this.price = price;
        this.location = location;
        this.image = image;
        this.foodType = foodType;
    }
}
