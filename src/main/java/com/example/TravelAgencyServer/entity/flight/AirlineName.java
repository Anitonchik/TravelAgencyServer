package com.example.TravelAgencyServer.entity.flight;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AirlineName {
    Aeroflot("Аэрофлот"),
    S7_Airlines("S7 Airlines"),
    Pobeda("Победа"),
    Russia("Россия"),
    Utair("Utair");

    public final String title;
}
