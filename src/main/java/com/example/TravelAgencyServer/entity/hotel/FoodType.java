package com.example.TravelAgencyServer.entity.hotel;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FoodType {
    RO ("без питания"),
    BB("только завтрак"),
    FB("полный пансион: завтрак, обед, ужин"),
    AI("все включено");

    private final String title;
}
