package com.example.TravelAgencyServer.entity.hotel;

import com.example.TravelAgencyServer.entity.reservation.ReservationEntity;
import com.example.TravelAgencyServer.entity.tour.TourEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class HotelEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double price;

    @Column(unique = true, nullable = false)
    private String location;

    @Column(nullable = false)
    private String image;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FoodType foodType;

    @OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY)
    private List<ReservationEntity> reservations = new ArrayList<>();

    public HotelEntity(String name, Double price,
                       String location, String image, FoodType foodType) {
        this.name = name;
        this.price = price;
        this.location = location;
        this.image = image;
        this.foodType = foodType;
    }
}
