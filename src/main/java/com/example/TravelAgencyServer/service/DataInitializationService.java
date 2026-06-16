package com.example.TravelAgencyServer.service;

import com.example.TravelAgencyServer.entity.flight.FlightEntity;
import com.example.TravelAgencyServer.entity.hotel.FoodType;
import com.example.TravelAgencyServer.entity.hotel.HotelEntity;
import com.example.TravelAgencyServer.entity.tour.TourCity;
import com.example.TravelAgencyServer.entity.tour.TourEntity;
import com.example.TravelAgencyServer.entity.tour.TourIntensity;
import com.example.TravelAgencyServer.entity.tour.TourType;
import com.example.TravelAgencyServer.repository.FlightRepository;
import com.example.TravelAgencyServer.repository.HotelRepository;
import com.example.TravelAgencyServer.repository.TourRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DataInitializationService {

    private final FlightRepository flightRepository;
    private final HotelRepository hotelRepository;
    private final TourRepository tourRepository;

    // ЕДИНАЯ КАРТИНКА ДЛЯ ВСЕХ ГОРОДОВ
    private static final String CITY_IMAGE = "https://www.shutterstock.com/shutterstock/photos/2275623129/display_1500/stock-photo-spasskaya-tower-of-moscow-kremlin-the-spasskaya-tower-is-the-main-tower-with-a-through-passage-on-2275623129.jpg";

    // ЕДИНАЯ КАРТИНКА ДЛЯ ВСЕХ ОТЕЛЕЙ
    private static final String HOTEL_IMAGE = "https://static3.depositphotos.com/1007115/227/i/450/depositphotos_2274403-stock-photo-richards-castle.jpg";

    @Transactional
    public void initializeToursData() {

        List<FlightEntity> allFlights = new ArrayList<>();
        List<HotelEntity> allHotels = new ArrayList<>();
        List<TourEntity> allTours = new ArrayList<>();

        // ==============================================
        // 1. СМОЛЕНСК
        // ==============================================

        FlightEntity flightToSmolensk1 = new FlightEntity(
                "Аэрофлот", "Ульяновск", "Смоленск",
                parseDate("2026-06-27 04:00:00"), 3500.0, 180
        );
        FlightEntity flightToSmolensk2 = new FlightEntity(
                "S7 Airlines", "Ульяновск", "Смоленск",
                parseDate("2026-06-27 08:30:00"), 3200.0, 150
        );
        FlightEntity flightFromSmolensk1 = new FlightEntity(
                "Аэрофлот", "Смоленск", "Ульяновск",
                parseDate("2026-07-04 06:00:00"), 3500.0, 180
        );
        FlightEntity flightFromSmolensk2 = new FlightEntity(
                "S7 Airlines", "Смоленск", "Ульяновск",
                parseDate("2026-07-04 10:30:00"), 3200.0, 150
        );

        allFlights.addAll(List.of(flightToSmolensk1, flightToSmolensk2, flightFromSmolensk1, flightFromSmolensk2));

        HotelEntity hotelSmolensk1 = new HotelEntity(
                "Смоленский дворик", 2500.0,
                "Смоленск, ул. Большая Советская, 15",
                HOTEL_IMAGE,
                FoodType.BB
        );
        HotelEntity hotelSmolensk2 = new HotelEntity(
                "Отель Смоленск", 3200.0,
                "Смоленск, ул. Дзержинского, 10",
                HOTEL_IMAGE,
                FoodType.RO
        );

        allHotels.addAll(List.of(hotelSmolensk1, hotelSmolensk2));

        for (int i = 1; i <= 8; i++) {
            TourEntity tour = new TourEntity(
                    "СМОЛЕНСК ТУР #" + i,
                    TourCity.SMOLENSK,
                    "Увлекательное путешествие в Смоленск с посещением Смоленской крепостной стены, Успенского собора и парка «Соловьиная роща». Вас ждут экскурсии по историческому центру, дегустация местной кухни и незабываемые виды на Днепр.",
                    4 + (i % 3) + " дня / " + (3 + (i % 3)) + " ночей",
                    25 + (i * 5),
                    15000.0 + (i * 2000),
                    parseDate("2026-06-27"),
                    parseDate("2026-07-04"),
                    true,
                    i % 2 == 0 ? TourType.EXCURSION : TourType.SPORTS,
                    i % 3 == 0 ? TourIntensity.Active : TourIntensity.Usual,
                    CITY_IMAGE,
                    List.of(flightToSmolensk1, flightToSmolensk2, flightFromSmolensk1, flightFromSmolensk2),
                    List.of(hotelSmolensk1, hotelSmolensk2)
            );
            allTours.add(tour);
        }

        // ==============================================
        // 2. МОСКВА
        // ==============================================

        FlightEntity flightToMoscow1 = new FlightEntity(
                "Аэрофлот", "Ульяновск", "Москва",
                parseDate("2026-07-10 08:00:00"), 8500.0, 180
        );
        FlightEntity flightToMoscow2 = new FlightEntity(
                "S7 Airlines", "Ульяновск", "Москва",
                parseDate("2026-07-10 12:30:00"), 7900.0, 150
        );
        FlightEntity flightFromMoscow1 = new FlightEntity(
                "Аэрофлот", "Москва", "Ульяновск",
                parseDate("2026-07-15 10:00:00"), 8500.0, 180
        );
        FlightEntity flightFromMoscow2 = new FlightEntity(
                "S7 Airlines", "Москва", "Ульяновск",
                parseDate("2026-07-15 15:30:00"), 7900.0, 150
        );

        allFlights.addAll(List.of(flightToMoscow1, flightToMoscow2, flightFromMoscow1, flightFromMoscow2));

        HotelEntity hotelMoscow1 = new HotelEntity(
                "Radisson Royal Hotel", 12500.0,
                "Москва, Кутузовский проспект, 2/1",
                HOTEL_IMAGE,
                FoodType.BB
        );
        HotelEntity hotelMoscow2 = new HotelEntity(
                "Балчуг Кемпински", 15000.0,
                "Москва, ул. Балчуг, 1",
                HOTEL_IMAGE,
                FoodType.BB
        );
        HotelEntity hotelMoscow3 = new HotelEntity(
                "Метрополь", 11000.0,
                "Москва, Театральный проезд, 2",
                HOTEL_IMAGE,
                FoodType.BB
        );

        allHotels.addAll(List.of(hotelMoscow1, hotelMoscow2, hotelMoscow3));

        for (int i = 1; i <= 8; i++) {
            TourEntity tour = new TourEntity(
                    "МОСКВА ТУР #" + i,
                    TourCity.MOSCOW,
                    "Знакомство с Москвой: Кремль, Красная площадь, ГУМ, храм Христа Спасителя, Воробьевы горы. Экскурсии по сталинским высоткам, прогулки по Арбату и парку Зарядье. " +
                            (i % 2 == 0 ? "Посещение Третьяковской галереи и Пушкинского музея." : "Экскурсия на ВДНХ и в парк «Царицыно»."),
                    5 + (i % 4) + " дня / " + (4 + (i % 4)) + " ночей",
                    20 + (i * 3),
                    25000.0 + (i * 3000),
                    parseDate("2026-07-10"),
                    parseDate("2026-07-15"),
                    true,
                    i % 2 == 0 ? TourType.EXCURSION : TourType.HEALTH,
                    i % 3 == 0 ? TourIntensity.Active : TourIntensity.Usual,
                    CITY_IMAGE,
                    List.of(flightToMoscow1, flightToMoscow2, flightFromMoscow1, flightFromMoscow2),
                    i % 3 == 0 ? List.of(hotelMoscow1, hotelMoscow3) : List.of(hotelMoscow2, hotelMoscow3)
            );
            allTours.add(tour);
        }

        // ==============================================
        // 3. САНКТ-ПЕТЕРБУРГ
        // ==============================================

        FlightEntity flightToSpb1 = new FlightEntity(
                "Аэрофлот", "Ульяновск", "Санкт-Петербург",
                parseDate("2026-07-20 06:30:00"), 9200.0, 170
        );
        FlightEntity flightToSpb2 = new FlightEntity(
                "Россия", "Ульяновск", "Санкт-Петербург",
                parseDate("2026-07-20 11:00:00"), 8800.0, 160
        );
        FlightEntity flightFromSpb1 = new FlightEntity(
                "Аэрофлот", "Санкт-Петербург", "Ульяновск",
                parseDate("2026-07-27 08:00:00"), 9200.0, 170
        );
        FlightEntity flightFromSpb2 = new FlightEntity(
                "Россия", "Санкт-Петербург", "Ульяновск",
                parseDate("2026-07-27 14:30:00"), 8800.0, 160
        );

        allFlights.addAll(List.of(flightToSpb1, flightToSpb2, flightFromSpb1, flightFromSpb2));

        HotelEntity hotelSpb1 = new HotelEntity(
                "Коринтия Санкт-Петербург", 9500.0,
                "Санкт-Петербург, Невский проспект, 57",
                HOTEL_IMAGE,
                FoodType.BB
        );
        HotelEntity hotelSpb2 = new HotelEntity(
                "Гранд Отель Европа", 18000.0,
                "Санкт-Петербург, Михайловская ул., 1/7",
                HOTEL_IMAGE,
                FoodType.BB
        );
        HotelEntity hotelSpb3 = new HotelEntity(
                "Отель Индиго", 7500.0,
                "Санкт-Петербург, ул. Чайковского, 17",
                HOTEL_IMAGE,
                FoodType.RO
        );

        allHotels.addAll(List.of(hotelSpb1, hotelSpb2, hotelSpb3));

        for (int i = 1; i <= 8; i++) {
            TourEntity tour = new TourEntity(
                    "САНКТ-ПЕТЕРБУРГ ТУР #" + i,
                    TourCity.SAINT_PETERSBURG,
                    "Северная столица России: Эрмитаж, Петропавловская крепость, Исаакиевский собор, прогулка по Невскому проспекту, разводные мосты. " +
                            (i % 2 == 0 ? "Посещение Царского Села и Петергофа." : "Экскурсия в Русский музей и на крейсер Аврора."),
                    4 + (i % 3) + " дня / " + (3 + (i % 3)) + " ночей",
                    20 + (i * 2),
                    28000.0 + (i * 2500),
                    parseDate("2026-07-20"),
                    parseDate("2026-07-27"),
                    true,
                    i % 2 == 0 ? TourType.EXCURSION : TourType.HEALTH,
                    i % 3 == 0 ? TourIntensity.Active : TourIntensity.Usual,
                    CITY_IMAGE,
                    List.of(flightToSpb1, flightToSpb2, flightFromSpb1, flightFromSpb2),
                    i % 3 == 0 ? List.of(hotelSpb2, hotelSpb1) : List.of(hotelSpb1, hotelSpb3)
            );
            allTours.add(tour);
        }

        // ==============================================
        // 4. КАЗАНЬ
        // ==============================================

        FlightEntity flightToKazan1 = new FlightEntity(
                "Аэрофлот", "Ульяновск", "Казань",
                parseDate("2026-08-01 09:00:00"), 6500.0, 150
        );
        FlightEntity flightToKazan2 = new FlightEntity(
                "Татарстан", "Ульяновск", "Казань",
                parseDate("2026-08-01 13:30:00"), 6200.0, 140
        );
        FlightEntity flightFromKazan1 = new FlightEntity(
                "Аэрофлот", "Казань", "Ульяновск",
                parseDate("2026-08-07 07:00:00"), 6500.0, 150
        );
        FlightEntity flightFromKazan2 = new FlightEntity(
                "Татарстан", "Казань", "Ульяновск",
                parseDate("2026-08-07 11:30:00"), 6200.0, 140
        );

        allFlights.addAll(List.of(flightToKazan1, flightToKazan2, flightFromKazan1, flightFromKazan2));

        HotelEntity hotelKazan1 = new HotelEntity(
                "Отель Жемчужный", 5500.0,
                "Казань, ул. Фатыха Карима, 14",
                HOTEL_IMAGE,
                FoodType.BB
        );
        HotelEntity hotelKazan2 = new HotelEntity(
                "Гранд Отель Казань", 8000.0,
                "Казань, ул. Петербургская, 1",
                HOTEL_IMAGE,
                FoodType.BB
        );

        allHotels.addAll(List.of(hotelKazan1, hotelKazan2));

        for (int i = 1; i <= 8; i++) {
            TourEntity tour = new TourEntity(
                    "КАЗАНЬ ТУР #" + i,
                    TourCity.KAZAN,
                    "Путешествие в столицу Татарстана: Казанский Кремль, мечеть Кул-Шариф, пешеходная улица Баумана, остров-град Свияжск. " +
                            (i % 2 == 0 ? "Дегустация татарской национальной кухни и экскурсия в Раифский монастырь." : "Посещение IT-парка и современного центра «Казань-Арена»."),
                    3 + (i % 4) + " дня / " + (2 + (i % 4)) + " ночей",
                    25 + (i * 3),
                    18000.0 + (i * 2000),
                    parseDate("2026-08-01"),
                    parseDate("2026-08-07"),
                    true,
                    i % 2 == 0 ? TourType.EXCURSION : TourType.SPORTS,
                    i % 3 == 0 ? TourIntensity.Active : TourIntensity.Usual,
                    CITY_IMAGE,
                    List.of(flightToKazan1, flightToKazan2, flightFromKazan1, flightFromKazan2),
                    List.of(hotelKazan1, hotelKazan2)
            );
            allTours.add(tour);
        }

        // ==============================================
        // 5. СОЧИ
        // ==============================================

        FlightEntity flightToSochi1 = new FlightEntity(
                "Аэрофлот", "Ульяновск", "Сочи",
                parseDate("2026-08-10 05:00:00"), 12000.0, 200
        );
        FlightEntity flightToSochi2 = new FlightEntity(
                "Победа", "Ульяновск", "Сочи",
                parseDate("2026-08-10 10:00:00"), 9800.0, 180
        );
        FlightEntity flightFromSochi1 = new FlightEntity(
                "Аэрофлот", "Сочи", "Ульяновск",
                parseDate("2026-08-17 08:00:00"), 12000.0, 200
        );
        FlightEntity flightFromSochi2 = new FlightEntity(
                "Победа", "Сочи", "Ульяновск",
                parseDate("2026-08-17 14:00:00"), 9800.0, 180
        );

        allFlights.addAll(List.of(flightToSochi1, flightToSochi2, flightFromSochi1, flightFromSochi2));

        HotelEntity hotelSochi1 = new HotelEntity(
                "Radisson Collection Paradise", 18000.0,
                "Сочи, ул. Санаторная, 45",
                HOTEL_IMAGE,
                FoodType.BB
        );
        HotelEntity hotelSochi2 = new HotelEntity(
                "Гранд Отель Жемчужина", 8500.0,
                "Сочи, ул. Морской, 3",
                HOTEL_IMAGE,
                FoodType.BB
        );
        HotelEntity hotelSochi3 = new HotelEntity(
                "Отель Парк Инн", 6500.0,
                "Сочи, Курортный проспект, 14",
                HOTEL_IMAGE,
                FoodType.RO
        );

        allHotels.addAll(List.of(hotelSochi1, hotelSochi2, hotelSochi3));

        for (int i = 1; i <= 8; i++) {
            TourEntity tour = new TourEntity(
                    "СОЧИ ТУР #" + i,
                    TourCity.SOCHI,
                    "Отдых на Черном море: пляжи, Олимпийский парк, Красная Поляна, прогулки по дендрарию, экскурсии в Ахунскую башню. " +
                            (i % 2 == 0 ? "Морская прогулка на яхте и посещение дельфинария." : "Экскурсия в Адлерский парк и океанариум."),
                    6 + (i % 5) + " дня / " + (5 + (i % 5)) + " ночей",
                    15 + (i * 2),
                    35000.0 + (i * 4000),
                    parseDate("2026-08-10"),
                    parseDate("2026-08-17"),
                    true,
                    i % 2 == 0 ? TourType.SPORTS : TourType.EXCURSION,
                    i % 3 == 0 ? TourIntensity.Active : TourIntensity.Active,
                    CITY_IMAGE,
                    List.of(flightToSochi1, flightToSochi2, flightFromSochi1, flightFromSochi2),
                    i % 3 == 0 ? List.of(hotelSochi1, hotelSochi3) : List.of(hotelSochi2, hotelSochi3)
            );
            allTours.add(tour);
        }

        // Сохраняем все в базу
        flightRepository.saveAll(allFlights);
        hotelRepository.saveAll(allHotels);
        tourRepository.saveAll(allTours);
    }

    private LocalDateTime parseDate(String dateString) {
        if (dateString.contains(":")) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            return LocalDateTime.parse(dateString, dtf);
        } else {
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return LocalDate.parse(dateString, df).atStartOfDay();
        }
    }
}