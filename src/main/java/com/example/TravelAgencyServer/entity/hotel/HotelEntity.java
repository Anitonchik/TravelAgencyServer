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
    @Enumerated(EnumType.STRING)
    @Column
    private FoodType foodType;
}
