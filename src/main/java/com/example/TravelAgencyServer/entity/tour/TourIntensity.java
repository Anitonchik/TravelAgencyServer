package com.example.TravelAgencyServer.entity.tour;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TourIntensity {
    Passive("Пассивный"),
    Usual("Обычный"),
    Active("Активный");

    private final String description;
}
