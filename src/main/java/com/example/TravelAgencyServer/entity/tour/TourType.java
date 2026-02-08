package com.example.TravelAgencyServer.entity.tour;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TourType {
    excursion("Экскурсионный"),
    HEALTH("Оздоровительные"),
    SPORTS("Спортивный");

    private final String title;
}
