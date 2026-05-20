package com.example.TravelAgencyServer.entity.reservation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum InsuranceType {
    MED("Медицинская страховка"),
    AII("Страхование от несчастных случаев"),
    CANC("Страхование отмены поездки"),
    CL("Страхование гражданской ответственности"),
    BAG("Страхование багажа"),
    NO("Нет страховки");

    private final String description;
}
