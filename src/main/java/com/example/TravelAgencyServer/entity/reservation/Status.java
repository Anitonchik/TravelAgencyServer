package com.example.TravelAgencyServer.entity.reservation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Status {
    CONFIRMED("Подтверждено"),
    EXPECTATION("Ожидает"),
    CANCELED("Отменено");

    private final String title;
}
