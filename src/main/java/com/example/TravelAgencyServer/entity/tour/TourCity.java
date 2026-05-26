package com.example.TravelAgencyServer.entity.tour;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TourCity {
    MOSCOW("Москва"),
    SAINT_PETERSBURG("Санкт-Петербург"),
    KAZAN("Казань"),
    SOCHI("Сочи"),
    NIZHNY_NOVGOROD("Нижний Новгород"),
    VLADIVOSTOK("Владивосток"),
    NOVOSIBIRSK("Новосибирск"),
    YEKATERINBURG("Екатеринбург"),
    KALININGRAD("Калининград"),
    YAROSLAVL("Ярославль"),
    SMOLENSK("Смоленск"),
    VELIKY_NOVGOROD("Великий Новгород"),
    KRASNODAR("Краснодар"),
    IRKUTSK("Иркутск"),
    TOBOLSK("Тобольск"),
    PSKOV("Псков"),
    SAMARA("Самара"),
    MURMANSK("Мурманск"),
    VOLGOGRAD("Волгоград"),
    UFA("Уфа"),
    KOLOMNA("Коломна"),
    KRASNOYARSK("Красноярск"),
    DERBENT("Дербент"),
    GELENDZHIK("Геленджик"),
    ANAPA("Анапа"),
    YELETS("Елец"),
    SEMENOV("Семёнов"),
    KUDYMKAR("Кудымкар"),
    YOSHKAR_OLA("Йошкар-Ола"),
    SARANSK("Саранск"),
    TULA("Тула"),
    VLADIMIR("Владимир"),
    SUZDAL("Суздаль"),
    SERGIEV_POSAD("Сергиев Посад"),
    ROSTOV_VELIKY("Ростов Великий"),
    PERESLAVL_ZALESSKY("Переславль-Залесский"),
    UGLICH("Углич"),
    KOSTROMA("Кострома"),
    BERDYANSK("Бердянск"),
    KAMENSK_URALSKY("Каменск-Уральский"),
    FEODOSIA("Феодосия"),
    TUAPSE("Туапсе"),
    YEYSK("Ейск"),
    NOVOROSSIYSK("Новороссийск"),
    PYATIGORSK("Пятигорск"),
    KISLOVODSK("Кисловодск");

    private final String description;
}
