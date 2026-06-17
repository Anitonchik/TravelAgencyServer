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

    private static final String CITY_IMAGE = "https://www.shutterstock.com/shutterstock/photos/2275623129/display_1500/stock-photo-spasskaya-tower-of-moscow-kremlin-the-spasskaya-tower-is-the-main-tower-with-a-through-passage-on-2275623129.jpg";
    private static final String HOTEL_IMAGE = "https://static3.depositphotos.com/1007115/227/i/450/depositphotos_2274403-stock-photo-richards-castle.jpg";

    @Transactional
    public void initializeToursData() {

        List<FlightEntity> allFlights = new ArrayList<>();
        List<HotelEntity> allHotels = new ArrayList<>();
        List<TourEntity> allTours = new ArrayList<>();

        // ==============================================
        // АВИАРЕЙСЫ В СМОЛЕНСК И ОБРАТНО
        // ==============================================

        FlightEntity flightToSmolensk1 = new FlightEntity(
                "Аэрофлот", "Ульяновск", "Смоленск",
                parseDate("2026-06-20 06:00:00"), 2800.0, 160
        );
        FlightEntity flightToSmolensk2 = new FlightEntity(
                "S7 Airlines", "Ульяновск", "Смоленск",
                parseDate("2026-06-20 10:30:00"), 2500.0, 140
        );
        FlightEntity flightToSmolensk3 = new FlightEntity(
                "Победа", "Ульяновск", "Смоленск",
                parseDate("2026-06-21 07:00:00"), 2200.0, 150
        );
        FlightEntity flightToSmolensk4 = new FlightEntity(
                "Аэрофлот", "Ульяновск", "Смоленск",
                parseDate("2026-06-22 05:30:00"), 2900.0, 165
        );
        FlightEntity flightToSmolensk5 = new FlightEntity(
                "S7 Airlines", "Ульяновск", "Смоленск",
                parseDate("2026-06-23 09:00:00"), 2600.0, 145
        );
        FlightEntity flightToSmolensk6 = new FlightEntity(
                "Аэрофлот", "Ульяновск", "Смоленск",
                parseDate("2026-06-25 08:00:00"), 2700.0, 155
        );
        FlightEntity flightToSmolensk7 = new FlightEntity(
                "S7 Airlines", "Ульяновск", "Смоленск",
                parseDate("2026-06-26 11:00:00"), 2400.0, 135
        );

        FlightEntity flightFromSmolensk1 = new FlightEntity(
                "Аэрофлот", "Смоленск", "Ульяновск",
                parseDate("2026-06-24 07:00:00"), 2800.0, 160
        );
        FlightEntity flightFromSmolensk2 = new FlightEntity(
                "S7 Airlines", "Смоленск", "Ульяновск",
                parseDate("2026-06-25 11:00:00"), 2500.0, 140
        );
        FlightEntity flightFromSmolensk3 = new FlightEntity(
                "Победа", "Смоленск", "Ульяновск",
                parseDate("2026-06-26 08:30:00"), 2200.0, 150
        );
        FlightEntity flightFromSmolensk4 = new FlightEntity(
                "Аэрофлот", "Смоленск", "Ульяновск",
                parseDate("2026-06-27 06:00:00"), 2900.0, 165
        );
        FlightEntity flightFromSmolensk5 = new FlightEntity(
                "S7 Airlines", "Смоленск", "Ульяновск",
                parseDate("2026-06-28 10:00:00"), 2600.0, 145
        );
        FlightEntity flightFromSmolensk6 = new FlightEntity(
                "Аэрофлот", "Смоленск", "Ульяновск",
                parseDate("2026-06-29 09:00:00"), 2700.0, 155
        );
        FlightEntity flightFromSmolensk7 = new FlightEntity(
                "S7 Airlines", "Смоленск", "Ульяновск",
                parseDate("2026-06-30 12:00:00"), 2400.0, 135
        );

        allFlights.addAll(List.of(
                flightToSmolensk1, flightToSmolensk2, flightToSmolensk3, flightToSmolensk4, flightToSmolensk5, flightToSmolensk6, flightToSmolensk7,
                flightFromSmolensk1, flightFromSmolensk2, flightFromSmolensk3, flightFromSmolensk4, flightFromSmolensk5, flightFromSmolensk6, flightFromSmolensk7
        ));

        // ==============================================
        // ОТЕЛИ В СМОЛЕНСКЕ
        // ==============================================

        HotelEntity hotelSmolensk1 = new HotelEntity(
                "Смоленский дворик", 1800.0,
                "Смоленск, ул. Большая Советская, 15",
                HOTEL_IMAGE,
                FoodType.BB
        );
        HotelEntity hotelSmolensk2 = new HotelEntity(
                "Отель Смоленск", 2300.0,
                "Смоленск, ул. Дзержинского, 10",
                HOTEL_IMAGE,
                FoodType.RO
        );
        HotelEntity hotelSmolensk3 = new HotelEntity(
                "Гостиница Русская", 1600.0,
                "Смоленск, ул. Октябрьской Революции, 7",
                HOTEL_IMAGE,
                FoodType.BB
        );
        HotelEntity hotelSmolensk4 = new HotelEntity(
                "Отель Покровский", 2100.0,
                "Смоленск, ул. Кашена, 20",
                HOTEL_IMAGE,
                FoodType.RO
        );
        HotelEntity hotelSmolensk5 = new HotelEntity(
                "Гостевой дом Смоленск", 1500.0,
                "Смоленск, ул. Багратиона, 12",
                HOTEL_IMAGE,
                FoodType.BB
        );
        HotelEntity hotelSmolensk6 = new HotelEntity(
                "Отель Центральный", 2500.0,
                "Смоленск, ул. Глинки, 5",
                HOTEL_IMAGE,
                FoodType.BB
        );
        HotelEntity hotelSmolensk7 = new HotelEntity(
                "Гостиница Днепр", 1900.0,
                "Смоленск, ул. Днепровская, 8",
                HOTEL_IMAGE,
                FoodType.RO
        );

        allHotels.addAll(List.of(hotelSmolensk1, hotelSmolensk2, hotelSmolensk3, hotelSmolensk4, hotelSmolensk5, hotelSmolensk6, hotelSmolensk7));

        // ==============================================
        // 10 ТУРОВ, УДОВЛЕТВОРЯЮЩИХ ПРЕДПОЧТЕНИЯМ КЛИЕНТА
        // (Смоленск, дата >= 2026-06-18, цена от 1000 до 5000)
        // ==============================================

        // ТУР #1
        TourEntity tour1 = new TourEntity(
                "Смоленск — Крепость и Днепр",
                TourCity.SMOLENSK,
                "Увлекательное путешествие по Смоленску: осмотр Смоленской крепостной стены, прогулка по набережной Днепра, посещение Успенского кафедрального собора и парка «Соловьиная роща». Дегустация местной кухни.",
                "3 дня / 2 ночи",
                20,
                15000.0,
                parseDate("2026-06-20"),
                parseDate("2026-06-22"),
                true,
                TourType.EXCURSION,
                TourIntensity.Usual,
                CITY_IMAGE,
                List.of(flightToSmolensk1, flightFromSmolensk1),
                List.of(hotelSmolensk1, hotelSmolensk3)
        );
        allTours.add(tour1);

        // ТУР #2
        TourEntity tour2 = new TourEntity(
                "Смоленск — Исторический уикенд",
                TourCity.SMOLENSK,
                "Погружение в историю Смоленска: экскурсия по древнему городу, посещение Смоленского кремля, храмов и монастырей. Прогулка по старинным улочкам.",
                "3 дня / 2 ночи",
                18,
                12000.0,
                parseDate("2026-06-21"),
                parseDate("2026-06-23"),
                true,
                TourType.EXCURSION,
                TourIntensity.Usual,
                CITY_IMAGE,
                List.of(flightToSmolensk2, flightFromSmolensk2),
                List.of(hotelSmolensk2, hotelSmolensk4)
        );
        allTours.add(tour2);

        // ТУР #3
        TourEntity tour3 = new TourEntity(
                "Смоленск — Активный отдых",
                TourCity.SMOLENSK,
                "Активный тур по Смоленску: пешие прогулки по городу, велопрогулка по набережной, посещение парков и скверов. Для любителей активного образа жизни.",
                "4 дня / 3 ночи",
                15,
                18000.0,
                parseDate("2026-06-20"),
                parseDate("2026-06-23"),
                true,
                TourType.SPORTS,
                TourIntensity.Active,
                CITY_IMAGE,
                List.of(flightToSmolensk3, flightFromSmolensk3),
                List.of(hotelSmolensk5, hotelSmolensk7)
        );
        allTours.add(tour3);

        // ТУР #4
        TourEntity tour4 = new TourEntity(
                "Смоленск — Культурное наследие",
                TourCity.SMOLENSK,
                "Экскурсия по культурным объектам Смоленска: музеи, галереи, театры. Посещение историко-архитектурного комплекса «Теремок».",
                "3 дня / 2 ночи",
                22,
                16000.0,
                parseDate("2026-06-22"),
                parseDate("2026-06-24"),
                true,
                TourType.EXCURSION,
                TourIntensity.Usual,
                CITY_IMAGE,
                List.of(flightToSmolensk4, flightFromSmolensk4),
                List.of(hotelSmolensk1, hotelSmolensk6)
        );
        allTours.add(tour4);

        // ТУР #5
        TourEntity tour5 = new TourEntity(
                "Смоленск — Выходные в городе",
                TourCity.SMOLENSK,
                "Идеальный тур на выходные: прогулка по центру, посещение Соборной горы, обзорная экскурсия с лучшими видами на город.",
                "2 дня / 1 ночь",
                25,
                14000.0,
                parseDate("2026-06-27"),
                parseDate("2026-06-28"),
                true,
                TourType.HEALTH,
                TourIntensity.Usual,
                CITY_IMAGE,
                List.of(flightToSmolensk5, flightFromSmolensk5),
                List.of(hotelSmolensk3, hotelSmolensk5)
        );
        allTours.add(tour5);

        // ТУР #6
        TourEntity tour6 = new TourEntity(
                "Смоленск — Древний город",
                TourCity.SMOLENSK,
                "Путешествие в один из древнейших городов России. Посещение Смоленской крепости, Успенского собора, прогулка по историческому центру.",
                "3 дня / 2 ночи",
                20,
                17000.0,
                parseDate("2026-06-23"),
                parseDate("2026-06-25"),
                true,
                TourType.EXCURSION,
                TourIntensity.Active,
                CITY_IMAGE,
                List.of(flightToSmolensk1, flightFromSmolensk6),
                List.of(hotelSmolensk2, hotelSmolensk7)
        );
        allTours.add(tour6);

        // ТУР #7
        TourEntity tour7 = new TourEntity(
                "Смоленск — Природа и история",
                TourCity.SMOLENSK,
                "Сочетание исторических экскурсий и прогулок по природным достопримечательностям. Посещение парка «Соловьиная роща» и Днепровских склонов.",
                "4 дня / 3 ночи",
                16,
                19000.0,
                parseDate("2026-06-24"),
                parseDate("2026-06-27"),
                true,
                TourType.SPORTS,
                TourIntensity.Active,
                CITY_IMAGE,
                List.of(flightToSmolensk2, flightFromSmolensk1),
                List.of(hotelSmolensk4, hotelSmolensk6)
        );
        allTours.add(tour7);

        // ТУР #8
        TourEntity tour8 = new TourEntity(
                "Смоленск — Релакс тур",
                TourCity.SMOLENSK,
                "Спокойный отдых в Смоленске: прогулки, экскурсии по храмам, посещение музеев и дегустация местных блюд. Для ценителей размеренного отдыха.",
                "3 дня / 2 ночи",
                15,
                13000.0,
                parseDate("2026-06-25"),
                parseDate("2026-06-27"),
                true,
                TourType.HEALTH,
                TourIntensity.Usual,
                CITY_IMAGE,
                List.of(flightToSmolensk3, flightFromSmolensk2),
                List.of(hotelSmolensk1, hotelSmolensk5)
        );
        allTours.add(tour8);

        // ТУР #9
        TourEntity tour9 = new TourEntity(
                "Смоленск — Городские легенды",
                TourCity.SMOLENSK,
                "Мистический тур по Смоленску: легенды и предания древнего города, посещение старинных особняков и подземелий.",
                "3 дня / 2 ночи",
                18,
                15500.0,
                parseDate("2026-06-26"),
                parseDate("2026-06-28"),
                true,
                TourType.EXCURSION,
                TourIntensity.Usual,
                CITY_IMAGE,
                List.of(flightToSmolensk4, flightFromSmolensk3),
                List.of(hotelSmolensk2, hotelSmolensk3)
        );
        allTours.add(tour9);

        // ТУР #10
        TourEntity tour10 = new TourEntity(
                "Смоленск — Семейный тур",
                TourCity.SMOLENSK,
                "Тур для всей семьи: экскурсии по городу, посещение парков, интерактивные программы для детей, дегустация местных сладостей.",
                "4 дня / 3 ночи",
                12,
                20000.0,
                parseDate("2026-06-28"),
                parseDate("2026-07-01"),
                true,
                TourType.EXCURSION,
                TourIntensity.Usual,
                CITY_IMAGE,
                List.of(flightToSmolensk5, flightFromSmolensk4),
                List.of(hotelSmolensk6, hotelSmolensk7)
        );
        allTours.add(tour10);

        // ==============================================
        // 5 ТУРОВ, НЕ УДОВЛЕТВОРЯЮЩИХ ПРЕДПОЧТЕНИЯМ КЛИЕНТА
        // ==============================================

        // ТУР #11 - ЦЕНА СЛИШКОМ НИЗКАЯ (800 < 1000)
        TourEntity tour11 = new TourEntity(
                "Смоленск — Эконом тур",
                TourCity.SMOLENSK,
                "Бюджетный тур в Смоленск для тех, кто хочет сэкономить. Прогулка по центру города, посещение бесплатных достопримечательностей.",
                "2 дня / 1 ночь",
                30,
                800.0,
                parseDate("2026-06-20"),
                parseDate("2026-06-21"),
                true,
                TourType.EXCURSION,
                TourIntensity.Usual,
                CITY_IMAGE,
                List.of(flightToSmolensk1, flightFromSmolensk1),
                List.of(hotelSmolensk5)
        );
        allTours.add(tour11);

        // ТУР #12 - ЦЕНА СЛИШКОМ ВЫСОКАЯ (6000 > 5000)
        TourEntity tour12 = new TourEntity(
                "Смоленск Премиум",
                TourCity.SMOLENSK,
                "Эксклюзивный тур в Смоленск с проживанием в лучших отелях, гастрономическими турами и индивидуальным гидом.",
                "5 дней / 4 ночи",
                5,
                6000.0,
                parseDate("2026-06-19"),
                parseDate("2026-06-23"),
                true,
                TourType.EXCURSION,
                TourIntensity.Active,
                CITY_IMAGE,
                List.of(flightToSmolensk2, flightFromSmolensk2),
                List.of(hotelSmolensk1, hotelSmolensk2)
        );
        allTours.add(tour12);

        // ТУР #13 - ДАТА РАНЬШЕ (2026-06-15 < 2026-06-18)
        TourEntity tour13 = new TourEntity(
                "Смоленск — Майские прогулки",
                TourCity.SMOLENSK,
                "Весенний тур в Смоленск: цветущие парки, исторические экскурсии, прогулки по набережной.",
                "3 дня / 2 ночи",
                20,
                11000.0,
                parseDate("2026-06-15"),
                parseDate("2026-06-17"),
                true,
                TourType.EXCURSION,
                TourIntensity.Usual,
                CITY_IMAGE,
                List.of(flightToSmolensk3, flightFromSmolensk3),
                List.of(hotelSmolensk3, hotelSmolensk4)
        );
        allTours.add(tour13);

        // ТУР #14 - ДАТА РАНЬШЕ (2026-06-16 < 2026-06-18) И ЦЕНА ВЫШЕ (5500 > 5000)
        TourEntity tour14 = new TourEntity(
                "Смоленск — Уикенд в древнем городе",
                TourCity.SMOLENSK,
                "Насыщенный тур на выходные: обзорная экскурсия, посещение музеев, прогулка по историческому центру.",
                "2 дня / 1 ночь",
                15,
                5500.0,
                parseDate("2026-06-16"),
                parseDate("2026-06-17"),
                true,
                TourType.SPORTS,
                TourIntensity.Active,
                CITY_IMAGE,
                List.of(flightToSmolensk4, flightFromSmolensk4),
                List.of(hotelSmolensk1, hotelSmolensk5)
        );
        allTours.add(tour14);

        // ТУР #15 - ЦЕНА ВЫШЕ (5200 > 5000)
        TourEntity tour15 = new TourEntity(
                "Смоленск — Гастрономический тур",
                TourCity.SMOLENSK,
                "Гастрономический тур по Смоленску: дегустация местных блюд, посещение ресторанов и кафе, мастер-классы по приготовлению традиционных блюд.",
                "3 дня / 2 ночи",
                12,
                5200.0,
                parseDate("2026-06-20"),
                parseDate("2026-06-22"),
                true,
                TourType.HEALTH,
                TourIntensity.Usual,
                CITY_IMAGE,
                List.of(flightToSmolensk5, flightFromSmolensk5),
                List.of(hotelSmolensk2, hotelSmolensk6)
        );
        allTours.add(tour15);

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