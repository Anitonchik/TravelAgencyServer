package com.example.TravelAgencyServer.service;

import com.example.TravelAgencyServer.entity.flight.FlightEntity;
import com.example.TravelAgencyServer.entity.hotel.FoodType;
import com.example.TravelAgencyServer.entity.hotel.HotelEntity;
import com.example.TravelAgencyServer.entity.manager.ManagerEntity;
import com.example.TravelAgencyServer.entity.tour.TourEntity;
import com.example.TravelAgencyServer.entity.tour.TourIntensity;
import com.example.TravelAgencyServer.entity.tour.TourType;
import com.example.TravelAgencyServer.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DataInitializationService {

    private final FlightRepository flightRepository;
    private final HotelRepository hotelRepository;
    private final TourRepository tourRepository;

    @Transactional
    public void initializeToursData() {

        // ========== РЕЙСЫ ИЗ УЛЬЯНОВСКА В РАЗНЫЕ НАПРАВЛЕНИЯ (ТУДА) ==========

        // Москва (3 рейса туда)
        FlightEntity flightToMoscow1 = new FlightEntity(
                "Аэрофлот", "Ульяновск", "Москва",
                parseDate("2025-06-10 08:00:00"), 8500.0, 180
        );
        FlightEntity flightToMoscow2 = new FlightEntity(
                "S7 Airlines", "Ульяновск", "Москва",
                parseDate("2025-06-10 12:30:00"), 7900.0, 150
        );
        FlightEntity flightToMoscow3 = new FlightEntity(
                "Победа", "Ульяновск", "Москва",
                parseDate("2025-06-10 18:45:00"), 6900.0, 200
        );

        // Москва (обратно)
        FlightEntity flightFromMoscow1 = new FlightEntity(
                "Аэрофлот", "Москва", "Ульяновск",
                parseDate("2025-06-15 10:00:00"), 8500.0, 180
        );
        FlightEntity flightFromMoscow2 = new FlightEntity(
                "S7 Airlines", "Москва", "Ульяновск",
                parseDate("2025-06-15 15:30:00"), 7900.0, 150
        );
        FlightEntity flightFromMoscow3 = new FlightEntity(
                "Победа", "Москва", "Ульяновск",
                parseDate("2025-06-15 20:15:00"), 6900.0, 200
        );

        // Санкт-Петербург (туда)
        FlightEntity flightToSpb1 = new FlightEntity(
                "Россия", "Ульяновск", "Санкт-Петербург",
                parseDate("2025-07-05 07:30:00"), 12500.0, 160
        );
        FlightEntity flightToSpb2 = new FlightEntity(
                "Северный Ветер", "Ульяновск", "Санкт-Петербург",
                parseDate("2025-07-05 14:20:00"), 11800.0, 140
        );

        // Санкт-Петербург (обратно)
        FlightEntity flightFromSpb1 = new FlightEntity(
                "Россия", "Санкт-Петербург", "Ульяновск",
                parseDate("2025-07-10 09:45:00"), 12500.0, 160
        );
        FlightEntity flightFromSpb2 = new FlightEntity(
                "Северный Ветер", "Санкт-Петербург", "Ульяновск",
                parseDate("2025-07-10 16:30:00"), 11800.0, 140
        );

        // Казань (туда)
        FlightEntity flightToKazan1 = new FlightEntity(
                "Татарстан Эйр", "Ульяновск", "Казань",
                parseDate("2025-06-20 09:00:00"), 4500.0, 120
        );
        FlightEntity flightToKazan2 = new FlightEntity(
                "Аэрофлот", "Ульяновск", "Казань",
                parseDate("2025-06-20 15:30:00"), 4900.0, 100
        );

        // Казань (обратно)
        FlightEntity flightFromKazan1 = new FlightEntity(
                "Татарстан Эйр", "Казань", "Ульяновск",
                parseDate("2025-06-24 11:00:00"), 4500.0, 120
        );
        FlightEntity flightFromKazan2 = new FlightEntity(
                "Аэрофлот", "Казань", "Ульяновск",
                parseDate("2025-06-24 17:30:00"), 4900.0, 100
        );

        // Нижний Новгород (туда)
        FlightEntity flightToNNovgorod1 = new FlightEntity(
                "S7 Airlines", "Ульяновск", "Нижний Новгород",
                parseDate("2025-07-15 08:45:00"), 5500.0, 130
        );
        FlightEntity flightToNNovgorod2 = new FlightEntity(
                "Азимут", "Ульяновск", "Нижний Новгород",
                parseDate("2025-07-15 13:15:00"), 5200.0, 110
        );

        // Нижний Новгород (обратно)
        FlightEntity flightFromNNovgorod1 = new FlightEntity(
                "S7 Airlines", "Нижний Новгород", "Ульяновск",
                parseDate("2025-07-20 10:30:00"), 5500.0, 130
        );
        FlightEntity flightFromNNovgorod2 = new FlightEntity(
                "Азимут", "Нижний Новгород", "Ульяновск",
                parseDate("2025-07-20 16:45:00"), 5200.0, 110
        );

        // Екатеринбург (туда)
        FlightEntity flightToEkaterinburg1 = new FlightEntity(
                "Уральские авиалинии", "Ульяновск", "Екатеринбург",
                parseDate("2025-08-01 06:30:00"), 9800.0, 140
        );
        FlightEntity flightToEkaterinburg2 = new FlightEntity(
                "Ред Вингс", "Ульяновск", "Екатеринбург",
                parseDate("2025-08-01 12:00:00"), 9200.0, 120
        );

        // Екатеринбург (обратно)
        FlightEntity flightFromEkaterinburg1 = new FlightEntity(
                "Уральские авиалинии", "Екатеринбург", "Ульяновск",
                parseDate("2025-08-07 07:45:00"), 9800.0, 140
        );
        FlightEntity flightFromEkaterinburg2 = new FlightEntity(
                "Ред Вингс", "Екатеринбург", "Ульяновск",
                parseDate("2025-08-07 14:15:00"), 9200.0, 120
        );

        // Новосибирск (туда)
        FlightEntity flightToNovosibirsk1 = new FlightEntity(
                "Сибирь", "Ульяновск", "Новосибирск",
                parseDate("2025-08-10 05:00:00"), 14500.0, 160
        );
        FlightEntity flightToNovosibirsk2 = new FlightEntity(
                "ЮТэйр", "Ульяновск", "Новосибирск",
                parseDate("2025-08-10 11:30:00"), 13800.0, 140
        );

        // Новосибирск (обратно)
        FlightEntity flightFromNovosibirsk1 = new FlightEntity(
                "Сибирь", "Новосибирск", "Ульяновск",
                parseDate("2025-08-17 06:15:00"), 14500.0, 160
        );
        FlightEntity flightFromNovosibirsk2 = new FlightEntity(
                "ЮТэйр", "Новосибирск", "Ульяновск",
                parseDate("2025-08-17 13:45:00"), 13800.0, 140
        );

        // Краснодар (туда)
        FlightEntity flightToKrasnodar1 = new FlightEntity(
                "Аэрофлот", "Ульяновск", "Краснодар",
                parseDate("2025-07-25 08:15:00"), 10500.0, 150
        );
        FlightEntity flightToKrasnodar2 = new FlightEntity(
                "Победа", "Ульяновск", "Краснодар",
                parseDate("2025-07-25 14:00:00"), 8900.0, 180
        );

        // Краснодар (обратно)
        FlightEntity flightFromKrasnodar1 = new FlightEntity(
                "Аэрофлот", "Краснодар", "Ульяновск",
                parseDate("2025-07-30 10:15:00"), 10500.0, 150
        );
        FlightEntity flightFromKrasnodar2 = new FlightEntity(
                "Победа", "Краснодар", "Ульяновск",
                parseDate("2025-07-30 16:30:00"), 8900.0, 180
        );

        // Калининград (туда)
        FlightEntity flightToKaliningrad1 = new FlightEntity(
                "Аэрофлот", "Ульяновск", "Калининград",
                parseDate("2025-08-20 07:00:00"), 15800.0, 140
        );
        FlightEntity flightToKaliningrad2 = new FlightEntity(
                "S7 Airlines", "Ульяновск", "Калининград",
                parseDate("2025-08-20 13:30:00"), 14900.0, 120
        );

        // Калининград (обратно)
        FlightEntity flightFromKaliningrad1 = new FlightEntity(
                "Аэрофлот", "Калининград", "Ульяновск",
                parseDate("2025-08-27 09:00:00"), 15800.0, 140
        );
        FlightEntity flightFromKaliningrad2 = new FlightEntity(
                "S7 Airlines", "Калининград", "Ульяновск",
                parseDate("2025-08-27 15:45:00"), 14900.0, 120
        );

        // Владивосток (туда)
        FlightEntity flightToVladivostok1 = new FlightEntity(
                "Аэрофлот", "Ульяновск", "Владивосток",
                parseDate("2025-09-01 04:00:00"), 28500.0, 200
        );
        FlightEntity flightToVladivostok2 = new FlightEntity(
                "S7 Airlines", "Ульяновск", "Владивосток",
                parseDate("2025-09-01 10:30:00"), 26900.0, 180
        );

        // Владивосток (обратно)
        FlightEntity flightFromVladivostok1 = new FlightEntity(
                "Аэрофлот", "Владивосток", "Ульяновск",
                parseDate("2025-09-10 05:30:00"), 28500.0, 200
        );
        FlightEntity flightFromVladivostok2 = new FlightEntity(
                "S7 Airlines", "Владивосток", "Ульяновск",
                parseDate("2025-09-10 13:00:00"), 26900.0, 180
        );

        // Крым (Симферополь) туда
        FlightEntity flightToCrimea1 = new FlightEntity(
                "Аэрофлот", "Ульяновск", "Симферополь",
                parseDate("2025-07-10 06:45:00"), 13200.0, 170
        );
        FlightEntity flightToCrimea2 = new FlightEntity(
                "S7 Airlines", "Ульяновск", "Симферополь",
                parseDate("2025-07-10 12:15:00"), 12500.0, 150
        );

        // Крым (обратно)
        FlightEntity flightFromCrimea1 = new FlightEntity(
                "Аэрофлот", "Симферополь", "Ульяновск",
                parseDate("2025-07-17 08:30:00"), 13200.0, 170
        );
        FlightEntity flightFromCrimea2 = new FlightEntity(
                "S7 Airlines", "Симферополь", "Ульяновск",
                parseDate("2025-07-17 14:45:00"), 12500.0, 150
        );

        // Алтай (Барнаул) туда
        FlightEntity flightToAltai1 = new FlightEntity(
                "Сибирь", "Ульяновск", "Барнаул",
                parseDate("2025-08-05 05:30:00"), 16800.0, 130
        );
        FlightEntity flightToAltai2 = new FlightEntity(
                "Аэрофлот", "Ульяновск", "Барнаул",
                parseDate("2025-08-05 12:00:00"), 17500.0, 110
        );

        // Алтай (обратно)
        FlightEntity flightFromAltai1 = new FlightEntity(
                "Сибирь", "Барнаул", "Ульяновск",
                parseDate("2025-08-14 07:15:00"), 16800.0, 130
        );
        FlightEntity flightFromAltai2 = new FlightEntity(
                "Аэрофлот", "Барнаул", "Ульяновск",
                parseDate("2025-08-14 14:30:00"), 17500.0, 110
        );

        // Байкал (Иркутск) туда
        FlightEntity flightToBaikal1 = new FlightEntity(
                "Сибирь", "Ульяновск", "Иркутск",
                parseDate("2025-09-05 04:30:00"), 22500.0, 150
        );
        FlightEntity flightToBaikal2 = new FlightEntity(
                "Уральские авиалинии", "Ульяновск", "Иркутск",
                parseDate("2025-09-05 11:00:00"), 21800.0, 130
        );

        // Байкал (обратно)
        FlightEntity flightFromBaikal1 = new FlightEntity(
                "Сибирь", "Иркутск", "Ульяновск",
                parseDate("2025-09-14 06:00:00"), 22500.0, 150
        );
        FlightEntity flightFromBaikal2 = new FlightEntity(
                "Уральские авиалинии", "Иркутск", "Ульяновск",
                parseDate("2025-09-14 13:30:00"), 21800.0, 130
        );

        // Сочи (туда)
        FlightEntity flightToSochi1 = new FlightEntity(
                "Аэрофлот", "Ульяновск", "Сочи",
                parseDate("2025-07-15 07:30:00"), 14200.0, 180
        );
        FlightEntity flightToSochi2 = new FlightEntity(
                "Россия", "Ульяновск", "Сочи",
                parseDate("2025-07-15 13:45:00"), 13500.0, 160
        );

        // Сочи (обратно)
        FlightEntity flightFromSochi1 = new FlightEntity(
                "Аэрофлот", "Сочи", "Ульяновск",
                parseDate("2025-07-22 09:15:00"), 14200.0, 180
        );
        FlightEntity flightFromSochi2 = new FlightEntity(
                "Россия", "Сочи", "Ульяновск",
                parseDate("2025-07-22 16:00:00"), 13500.0, 160
        );

        // Минеральные Воды (туда)
        FlightEntity flightToMinVody1 = new FlightEntity(
                "Аэрофлот", "Ульяновск", "Минеральные Воды",
                parseDate("2025-08-10 07:00:00"), 11800.0, 140
        );
        FlightEntity flightToMinVody2 = new FlightEntity(
                "Победа", "Ульяновск", "Минеральные Воды",
                parseDate("2025-08-10 12:45:00"), 9900.0, 170
        );

        // Минеральные Воды (обратно)
        FlightEntity flightFromMinVody1 = new FlightEntity(
                "Аэрофлот", "Минеральные Воды", "Ульяновск",
                parseDate("2025-08-17 08:30:00"), 11800.0, 140
        );
        FlightEntity flightFromMinVody2 = new FlightEntity(
                "Победа", "Минеральные Воды", "Ульяновск",
                parseDate("2025-08-17 14:15:00"), 9900.0, 170
        );

        // Ростов-на-Дону (туда)
        FlightEntity flightToRostov1 = new FlightEntity(
                "Азимут", "Ульяновск", "Ростов-на-Дону",
                parseDate("2025-09-10 08:30:00"), 8500.0, 135
        );
        FlightEntity flightToRostov2 = new FlightEntity(
                "S7 Airlines", "Ульяновск", "Ростов-на-Дону",
                parseDate("2025-09-10 14:15:00"), 8900.0, 115
        );

        // Ростов-на-Дону (обратно)
        FlightEntity flightFromRostov1 = new FlightEntity(
                "Азимут", "Ростов-на-Дону", "Ульяновск",
                parseDate("2025-09-17 10:00:00"), 8500.0, 135
        );
        FlightEntity flightFromRostov2 = new FlightEntity(
                "S7 Airlines", "Ростов-на-Дону", "Ульяновск",
                parseDate("2025-09-17 16:30:00"), 8900.0, 115
        );

        // Волгоград (туда)
        FlightEntity flightToVolgograd1 = new FlightEntity(
                "Победа", "Ульяновск", "Волгоград",
                parseDate("2025-08-20 09:15:00"), 5500.0, 155
        );
        FlightEntity flightToVolgograd2 = new FlightEntity(
                "Аэрофлот", "Ульяновск", "Волгоград",
                parseDate("2025-08-20 15:00:00"), 6200.0, 125
        );

        // Волгоград (обратно)
        FlightEntity flightFromVolgograd1 = new FlightEntity(
                "Победа", "Волгоград", "Ульяновск",
                parseDate("2025-08-26 11:30:00"), 5500.0, 155
        );
        FlightEntity flightFromVolgograd2 = new FlightEntity(
                "Аэрофлот", "Волгоград", "Ульяновск",
                parseDate("2025-08-26 17:45:00"), 6200.0, 125
        );

        // Самара (туда)
        FlightEntity flightToSamara1 = new FlightEntity(
                "Азимут", "Ульяновск", "Самара",
                parseDate("2025-09-25 10:30:00"), 3900.0, 110
        );
        FlightEntity flightToSamara2 = new FlightEntity(
                "Ред Вингс", "Ульяновск", "Самара",
                parseDate("2025-09-25 16:15:00"), 4200.0, 95
        );

        // Самара (обратно)
        FlightEntity flightFromSamara1 = new FlightEntity(
                "Азимут", "Самара", "Ульяновск",
                parseDate("2025-09-30 12:00:00"), 3900.0, 110
        );
        FlightEntity flightFromSamara2 = new FlightEntity(
                "Ред Вингс", "Самара", "Ульяновск",
                parseDate("2025-09-30 18:30:00"), 4200.0, 95
        );

        // Сохраняем все рейсы
        flightRepository.saveAll(List.of(
                flightToMoscow1, flightToMoscow2, flightToMoscow3,
                flightFromMoscow1, flightFromMoscow2, flightFromMoscow3,
                flightToSpb1, flightToSpb2, flightFromSpb1, flightFromSpb2,
                flightToKazan1, flightToKazan2, flightFromKazan1, flightFromKazan2,
                flightToNNovgorod1, flightToNNovgorod2, flightFromNNovgorod1, flightFromNNovgorod2,
                flightToEkaterinburg1, flightToEkaterinburg2, flightFromEkaterinburg1, flightFromEkaterinburg2,
                flightToNovosibirsk1, flightToNovosibirsk2, flightFromNovosibirsk1, flightFromNovosibirsk2,
                flightToKrasnodar1, flightToKrasnodar2, flightFromKrasnodar1, flightFromKrasnodar2,
                flightToKaliningrad1, flightToKaliningrad2, flightFromKaliningrad1, flightFromKaliningrad2,
                flightToVladivostok1, flightToVladivostok2, flightFromVladivostok1, flightFromVladivostok2,
                flightToCrimea1, flightToCrimea2, flightFromCrimea1, flightFromCrimea2,
                flightToAltai1, flightToAltai2, flightFromAltai1, flightFromAltai2,
                flightToBaikal1, flightToBaikal2, flightFromBaikal1, flightFromBaikal2,
                flightToSochi1, flightToSochi2, flightFromSochi1, flightFromSochi2,
                flightToMinVody1, flightToMinVody2, flightFromMinVody1, flightFromMinVody2,
                flightToRostov1, flightToRostov2, flightFromRostov1, flightFromRostov2,
                flightToVolgograd1, flightToVolgograd2, flightFromVolgograd1, flightFromVolgograd2,
                flightToSamara1, flightToSamara2, flightFromSamara1, flightFromSamara2
        ));

        // ========== ОТЕЛИ ==========

        // Москва отели
        HotelEntity hotelMoscow1 = new HotelEntity(
                "Metropol Moscow", 18500.0,
                "Москва, Театральный проезд, 2",
                "https://cf.bstatic.com/xdata/images/hotel/max1024x768/235935264.jpg",
                FoodType.FB
        );
        HotelEntity hotelMoscow2 = new HotelEntity(
                "Radisson Blu Moscow", 15900.0,
                "Москва, Кутузовский проспект, 2/1",
                "https://cf.bstatic.com/xdata/images/hotel/max1024x768/292119522.jpg",
                FoodType.RO
        );

        // СПб отели
        HotelEntity hotelSpb1 = new HotelEntity(
                "Four Seasons Lion Palace", 22500.0,
                "Санкт-Петербург, Вознесенский пр., 1",
                "https://cf.bstatic.com/xdata/images/hotel/max1024x768/145348529.jpg",
                FoodType.FB
        );
        HotelEntity hotelSpb2 = new HotelEntity(
                "W St. Petersburg", 16800.0,
                "Санкт-Петербург, Вознесенский пр., 6",
                "https://cf.bstatic.com/xdata/images/hotel/max1024x768/77330925.jpg",
                FoodType.RO
        );

        // Казань отели
        HotelEntity hotelKazan1 = new HotelEntity(
                "Kazan Palace", 8900.0,
                "Казань, ул. Баумана, 15",
                "https://cf.bstatic.com/xdata/images/hotel/max1024x768/156880124.jpg",
                FoodType.FB
        );
        HotelEntity hotelKazan2 = new HotelEntity(
                "Ramada Kazan", 7200.0,
                "Казань, ул. Петербургская, 1",
                "https://cf.bstatic.com/xdata/images/hotel/max1024x768/197286345.jpg",
                FoodType.BB
        );

        // Нижний Новгород отели
        HotelEntity hotelNNovgorod1 = new HotelEntity(
                "Sheraton Nizhny", 10500.0,
                "Нижний Новгород, ул. Алексеевская, 10",
                "https://cf.bstatic.com/xdata/images/hotel/max1024x768/218377428.jpg",
                FoodType.RO
        );
        HotelEntity hotelNNovgorod2 = new HotelEntity(
                "Marins Park Hotel", 6800.0,
                "Нижний Новгород, ул. Советская, 12",
                "https://cf.bstatic.com/xdata/images/hotel/max1024x768/152886594.jpg",
                FoodType.RO
        );

        // Екатеринбург отели
        HotelEntity hotelEkaterinburg1 = new HotelEntity(
                "Hyatt Regency Ekaterinburg", 12500.0,
                "Екатеринбург, ул. Бориса Ельцина, 8",
                "https://cf.bstatic.com/xdata/images/hotel/max1024x768/82035451.jpg",
                FoodType.FB
        );
        HotelEntity hotelEkaterinburg2 = new HotelEntity(
                "Vysotsky Hotel", 9800.0,
                "Екатеринбург, пр. Ленина, 52",
                "https://cf.bstatic.com/xdata/images/hotel/max1024x768/31055762.jpg",
                FoodType.RO
        );

        // Новосибирск отели
        HotelEntity hotelNovosibirsk1 = new HotelEntity(
                "Marriott Novosibirsk", 11200.0,
                "Новосибирск, ул. Орджоникидзе, 30",
                "https://cf.bstatic.com/xdata/images/hotel/max1024x768/165886521.jpg",
                FoodType.FB
        );
        HotelEntity hotelNovosibirsk2 = new HotelEntity(
                "DoubleTree Novosibirsk", 9500.0,
                "Новосибирск, ул. Каменская, 32",
                "https://cf.bstatic.com/xdata/images/hotel/max1024x768/290933087.jpg",
                FoodType.RO
        );

        // Краснодар отели
        HotelEntity hotelKrasnodar1 = new HotelEntity(
                "Hilton Garden Inn Krasnodar", 8500.0,
                "Краснодар, ул. Красная, 105",
                "https://cf.bstatic.com/xdata/images/hotel/max1024x768/133998451.jpg",
                FoodType.RO
        );
        HotelEntity hotelKrasnodar2 = new HotelEntity(
                "Mercure Krasnodar", 7900.0,
                "Краснодар, ул. Шоссе Нефтяников, 34",
                "https://cf.bstatic.com/xdata/images/hotel/max1024x768/137748836.jpg",
                FoodType.BB
        );

        // Калининград отели
        HotelEntity hotelKaliningrad1 = new HotelEntity(
                "Radisson Kaliningrad", 11800.0,
                "Калининград, пл. Победы, 10",
                "https://cf.bstatic.com/xdata/images/hotel/max1024x768/138350039.jpg",
                FoodType.FB
        );
        HotelEntity hotelKaliningrad2 = new HotelEntity(
                "Mercure Kaliningrad", 9500.0,
                "Калининград, ул. Генерала Челнокова, 11",
                "https://cf.bstatic.com/xdata/images/hotel/max1024x768/187492701.jpg",
                FoodType.RO
        );

        // Владивосток отели
        HotelEntity hotelVladivostok1 = new HotelEntity(
                "Hyundai Hotel Vladivostok", 14900.0,
                "Владивосток, ул. Семеновская, 29",
                "https://cf.bstatic.com/xdata/images/hotel/max1024x768/227172670.jpg",
                FoodType.FB
        );
        HotelEntity hotelVladivostok2 = new HotelEntity(
                "Azimut Vladivostok", 11200.0,
                "Владивосток, ул. Набережная, 10",
                "https://cf.bstatic.com/xdata/images/hotel/max1024x768/192957373.jpg",
                FoodType.RO
        );

        // Крым отели
        HotelEntity hotelCrimea1 = new HotelEntity(
                "Mriya Resort & Spa", 22500.0,
                "Крым, Ялта, с. Оползневое",
                "https://cf.bstatic.com/xdata/images/hotel/max1024x768/191457829.jpg",
                FoodType.AI
        );
        HotelEntity hotelCrimea2 = new HotelEntity(
                "Yalta Intourist", 10500.0,
                "Крым, Ялта, ул. Дражинского, 50",
                "https://cf.bstatic.com/xdata/images/hotel/max1024x768/40491038.jpg",
                FoodType.RO
        );

        // Алтай отели
        HotelEntity hotelAltai1 = new HotelEntity(
                "Altai Resort", 13500.0,
                "Республика Алтай, Чемальский р-н",
                "https://cf.bstatic.com/xdata/images/hotel/max1024x768/227448362.jpg",
                FoodType.FB
        );
        HotelEntity hotelAltai2 = new HotelEntity(
                "Chemal Park Hotel", 8900.0,
                "Республика Алтай, Чемал, ул. Заречная, 1",
                "https://cf.bstatic.com/xdata/images/hotel/max1024x768/165468374.jpg",
                FoodType.RO
        );

        // Байкал отели
        HotelEntity hotelBaikal1 = new HotelEntity(
                "Mayak Hotel Baikal", 15500.0,
                "Иркутская обл., Листвянка, ул. Горького, 85",
                "https://cf.bstatic.com/xdata/images/hotel/max1024x768/225565254.jpg",
                FoodType.FB
        );
        HotelEntity hotelBaikal2 = new HotelEntity(
                "Baikal Residence", 12800.0,
                "Иркутская обл., Листвянка",
                "https://cf.bstatic.com/xdata/images/hotel/max1024x768/101993750.jpg",
                FoodType.RO
        );

        // Сочи отели
        HotelEntity hotelSochi1 = new HotelEntity(
                "Radisson Resort Sochi", 16800.0,
                "Сочи, ул. Голубая, 11",
                "https://cf.bstatic.com/xdata/images/hotel/max1024x768/215396335.jpg",
                FoodType.FB
        );
        HotelEntity hotelSochi2 = new HotelEntity(
                "Grand Hotel Polyana", 19500.0,
                "Сочи, Эстосадок, ул. Горная, 9",
                "https://cf.bstatic.com/xdata/images/hotel/max1024x768/118527639.jpg",
                FoodType.RO
        );

        // Кисловодск (МинВоды) отели
        HotelEntity hotelMinVody1 = new HotelEntity(
                "Grand Hotel Kislovodsk", 12500.0,
                "Кисловодск, ул. Ленина, 17",
                "https://cf.bstatic.com/xdata/images/hotel/max1024x768/166953308.jpg",
                FoodType.FB
        );
        HotelEntity hotelMinVody2 = new HotelEntity(
                "Sanatorium Valley", 9500.0,
                "Кисловодск, ул. Курортный бульвар, 12",
                "https://cf.bstatic.com/xdata/images/hotel/max1024x768/219916562.jpg",
                FoodType.RO
        );

        // Ростов-на-Дону отели
        HotelEntity hotelRostov1 = new HotelEntity(
                "Marriott Rostov", 9900.0,
                "Ростов-на-Дону, ул. Б. Садовая, 115",
                "https://cf.bstatic.com/xdata/images/hotel/max1024x768/148826571.jpg",
                FoodType.RO
        );
        HotelEntity hotelRostov2 = new HotelEntity(
                "Don Plaza", 7500.0,
                "Ростов-на-Дону, пл. Пятилетки, 1",
                "https://cf.bstatic.com/xdata/images/hotel/max1024x768/68068654.jpg",
                FoodType.BB
        );

        // Волгоград отели
        HotelEntity hotelVolgograd1 = new HotelEntity(
                "Volgograd Hotel", 6500.0,
                "Волгоград, ул. Мира, 12",
                "https://cf.bstatic.com/xdata/images/hotel/max1024x768/75214931.jpg",
                FoodType.RO
        );
        HotelEntity hotelVolgograd2 = new HotelEntity(
                "Park House", 5800.0,
                "Волгоград, пр. Ленина, 37",
                "https://cf.bstatic.com/xdata/images/hotel/max1024x768/163645679.jpg",
                FoodType.RO
        );

        // Самара отели
        HotelEntity hotelSamara1 = new HotelEntity(
                "Lotte Hotel Samara", 13500.0,
                "Самара, ул. Алексея Толстого, 36",
                "https://cf.bstatic.com/xdata/images/hotel/max1024x768/173489313.jpg",
                FoodType.FB
        );
        HotelEntity hotelSamara2 = new HotelEntity(
                "Holiday Inn Samara", 8900.0,
                "Самара, ул. Аэродромная, 47а",
                "https://cf.bstatic.com/xdata/images/hotel/max1024x768/72443898.jpg",
                FoodType.RO
        );

        hotelRepository.saveAll(List.of(
                hotelMoscow1, hotelMoscow2, hotelSpb1, hotelSpb2,
                hotelKazan1, hotelKazan2, hotelNNovgorod1, hotelNNovgorod2,
                hotelEkaterinburg1, hotelEkaterinburg2, hotelNovosibirsk1, hotelNovosibirsk2,
                hotelKrasnodar1, hotelKrasnodar2, hotelKaliningrad1, hotelKaliningrad2,
                hotelVladivostok1, hotelVladivostok2, hotelCrimea1, hotelCrimea2,
                hotelAltai1, hotelAltai2, hotelBaikal1, hotelBaikal2,
                hotelSochi1, hotelSochi2, hotelMinVody1, hotelMinVody2,
                hotelRostov1, hotelRostov2, hotelVolgograd1, hotelVolgograd2,
                hotelSamara1, hotelSamara2
        ));

        // ========== 20 ТУРОВ ==========

        // Тур 1: Москва - Культурная столица
        TourEntity tour1 = new TourEntity(
                "МОСКВА-ГРАД 5 дней", "Москва",
                "Погружение в историю и культуру Москвы: Кремль, Красная площадь, Третьяковская галерея и лучшие рестораны",
                "5 дней/4 ночи", 40, 42500.0,
                parseDate("2025-06-10"), parseDate("2025-06-15"), true,
                TourType.EXCURSION, TourIntensity.Usual,
                List.of(flightToMoscow1, flightToMoscow2, flightFromMoscow1, flightFromMoscow2),
                List.of(hotelMoscow1, hotelMoscow2)
        );

        // Тур 2: Москва VIP
        TourEntity tour2 = new TourEntity(
                "МОСКВА VIP 7 дней", "Москва",
                "Элитный тур по Москве: бутик-отели, лучшие рестораны, Большой театр и шопинг в ЦУМе",
                "7 дней/6 ночей", 20, 89500.0,
                parseDate("2025-07-01"), parseDate("2025-07-08"), true,
                TourType.EXCURSION, TourIntensity.Passive,
                List.of(flightToMoscow1, flightToMoscow3, flightFromMoscow2, flightFromMoscow3),
                List.of(hotelMoscow2, hotelMoscow1)
        );

        // Тур 3: Санкт-Петербург - Северная Венеция
        TourEntity tour3 = new TourEntity(
                "ПИТЕР-ЭКСПРЕСС 6 дней", "Санкт-Петербург",
                "Эрмитаж, Петергоф, Царское Село, экскурсия по рекам и каналам",
                "6 дней/5 ночей", 35, 49800.0,
                parseDate("2025-07-05"), parseDate("2025-07-11"), true,
                TourType.EXCURSION, TourIntensity.Usual,
                List.of(flightToSpb1, flightToSpb2, flightFromSpb1, flightFromSpb2),
                List.of(hotelSpb1, hotelSpb2)
        );

        // Тур 4: Казань - Татарстан открытие
        TourEntity tour4 = new TourEntity(
                "КАЗАНЬ - ТРЕТЬЯ СТОЛИЦА 4 дня", "Казань",
                "Казанский Кремль, мечеть Кул-Шариф, остров-град Свияжск, татарская кухня",
                "4 дня/3 ночи", 45, 28500.0,
                parseDate("2025-06-20"), parseDate("2025-06-24"), true,
                TourType.EXCURSION, TourIntensity.Usual,
                List.of(flightToKazan1, flightToKazan2, flightFromKazan1, flightFromKazan2),
                List.of(hotelKazan1, hotelKazan2)
        );

        // Тур 5: Нижний Новгород - Стрелка волжская
        TourEntity tour5 = new TourEntity(
                "НИЖНИЙ НОВГОРОД - СЕРДЦЕ ПОВОЛЖЬЯ 4 дня", "Нижний Новгород",
                "Нижегородский кремль, Чкаловская лестница, ярмарка, прогулка по набережной",
                "4 дня/3 ночи", 45, 24500.0,
                parseDate("2025-07-15"), parseDate("2025-07-19"), true,
                TourType.EXCURSION, TourIntensity.Passive,
                List.of(flightToNNovgorod1, flightToNNovgorod2, flightFromNNovgorod1, flightFromNNovgorod2),
                List.of(hotelNNovgorod1, hotelNNovgorod2)
        );

        // Тур 6: Екатеринбург - Уральский экспресс
        TourEntity tour6 = new TourEntity(
                "ЕКАТЕРИНБУРГ - ГРАНИЦА ЕВРОПЫ 6 дней", "Екатеринбург",
                "Экскурсия по Екатеринбургу, граница Европа-Азия, Ганина Яма, Невьянская башня",
                "6 дней/5 ночей", 30, 39500.0,
                parseDate("2025-08-01"), parseDate("2025-08-07"), true,
                TourType.EXCURSION, TourIntensity.Usual,
                List.of(flightToEkaterinburg1, flightToEkaterinburg2, flightFromEkaterinburg1, flightFromEkaterinburg2),
                List.of(hotelEkaterinburg1, hotelEkaterinburg2)
        );

        // Тур 7: Новосибирск - Сибирское приключение
        TourEntity tour7 = new TourEntity(
                "НОВОСИБИРСК - СИБИРСКАЯ СИЛА 7 дней", "Новосибирск",
                "Новосибирск, Академгородок, Обское море, Бердские скалы",
                "7 дней/6 ночей", 35, 52500.0,
                parseDate("2025-08-10"), parseDate("2025-08-17"), true,
                TourType.EXCURSION, TourIntensity.Active,
                List.of(flightToNovosibirsk1, flightToNovosibirsk2, flightFromNovosibirsk1, flightFromNovosibirsk2),
                List.of(hotelNovosibirsk1, hotelNovosibirsk2)
        );

        // Тур 8: Краснодар - Кубанская жемчужина
        TourEntity tour8 = new TourEntity(
                "КРАСНОДАР - ЛУЧШИЙ ЮГ 5 дней", "Краснодар",
                "Экскурсии по Краснодару, парк Галицкого, кубанские вина, краснодарский край",
                "5 дней/4 ночи", 40, 35800.0,
                parseDate("2025-07-25"), parseDate("2025-07-30"), true,
                TourType.EXCURSION, TourIntensity.Usual,
                List.of(flightToKrasnodar1, flightToKrasnodar2, flightFromKrasnodar1, flightFromKrasnodar2),
                List.of(hotelKrasnodar1, hotelKrasnodar2)
        );

        // Тур 9: Калининград - Самый западный форпост
        TourEntity tour9 = new TourEntity(
                "КАЛИНИНГРАД - ПРУССКИЕ СКАЗКИ 7 дней", "Калининград",
                "Кафедральный собор, Куршская коса, форты Кенигсберга, Музей янтаря",
                "7 дней/6 ночей", 30, 55800.0,
                parseDate("2025-08-20"), parseDate("2025-08-27"), true,
                TourType.EXCURSION, TourIntensity.Usual,
                List.of(flightToKaliningrad1, flightToKaliningrad2, flightFromKaliningrad1, flightFromKaliningrad2),
                List.of(hotelKaliningrad1, hotelKaliningrad2)
        );

        // Тур 10: Владивосток - Конец земли
        TourEntity tour10 = new TourEntity(
                "ВЛАДИВОСТОК - МОРСКАЯ КРЕПОСТЬ 9 дней", "Владивосток",
                "Золотой мост, Русский мост, остров Русский, маяк Токаревского, морская прогулка",
                "9 дней/8 ночей", 40, 89500.0,
                parseDate("2025-09-01"), parseDate("2025-09-10"), true,
                TourType.EXCURSION, TourIntensity.Active,
                List.of(flightToVladivostok1, flightToVladivostok2, flightFromVladivostok1, flightFromVladivostok2),
                List.of(hotelVladivostok1, hotelVladivostok2)
        );

        // Тур 11: Крым - Солнечный полуостров
        TourEntity tour11 = new TourEntity(
                "КРЫМ - ЛАСТОЧКИНО ГНЕЗДО 7 дней", "Крым",
                "Ялта, Севастополь, Ливадийский дворец, Ай-Петри, Ласточкино гнездо",
                "7 дней/6 ночей", 45, 52800.0,
                parseDate("2025-07-10"), parseDate("2025-07-17"), true,
                TourType.EXCURSION, TourIntensity.Passive,
                List.of(flightToCrimea1, flightToCrimea2, flightFromCrimea1, flightFromCrimea2),
                List.of(hotelCrimea1, hotelCrimea2)
        );

        // Тур 12: Алтай - Горная сила
        TourEntity tour12 = new TourEntity(
                "АЛТАЙ - СИЛА ПРИРОДЫ 9 дней", "Алтай",
                "Телецкое озеро, Чуйский тракт, долина реки Катунь, конные прогулки",
                "9 дней/8 ночей", 25, 78900.0,
                parseDate("2025-08-05"), parseDate("2025-08-14"), true,
                TourType.SPORTS, TourIntensity.Active,
                List.of(flightToAltai1, flightToAltai2, flightFromAltai1, flightFromAltai2),
                List.of(hotelAltai1, hotelAltai2)
        );

        // Тур 13: Байкал - Священное море
        TourEntity tour13 = new TourEntity(
                "БАЙКАЛ - ЖЕМЧУЖИНА РОССИИ 9 дней", "Байкал",
                "Озеро Байкал, остров Ольхон, шаман-камень, КБЖД, горячие источники",
                "9 дней/8 ночей", 35, 89500.0,
                parseDate("2025-09-05"), parseDate("2025-09-14"), true,
                TourType.SPORTS, TourIntensity.Active,
                List.of(flightToBaikal1, flightToBaikal2, flightFromBaikal1, flightFromBaikal2),
                List.of(hotelBaikal1, hotelBaikal2)
        );

        // Тур 14: Сочи - Лучший пляж
        TourEntity tour14 = new TourEntity(
                "СОЧИ - МОРСКОЙ БРИЗ 7 дней", "Сочи",
                "Олимпийский парк, пляжи Имеретинки, дендрарий, Ахун, парк Ривьера",
                "7 дней/6 ночей", 50, 58900.0,
                parseDate("2025-07-15"), parseDate("2025-07-22"), true,
                TourType.EXCURSION, TourIntensity.Passive,
                List.of(flightToSochi1, flightToSochi2, flightFromSochi1, flightFromSochi2),
                List.of(hotelSochi1, hotelSochi2)
        );

        // Тур 15: Кисловодск - Кавказское здоровье
        TourEntity tour15 = new TourEntity(
                "КИСЛОВОДСК - НАРЗАННЫЙ РАЙ 7 дней", "Кисловодск",
                "Лечение минеральными водами, Курортный парк, гора Кольцо, Долина роз",
                "7 дней/6 ночей", 40, 45900.0,
                parseDate("2025-08-10"), parseDate("2025-08-17"), true,
                TourType.EXCURSION, TourIntensity.Passive,
                List.of(flightToMinVody1, flightToMinVody2, flightFromMinVody1, flightFromMinVody2),
                List.of(hotelMinVody1, hotelMinVody2)
        );

        // Тур 16: Ростов-на-Дону - Донская вольница
        TourEntity tour16 = new TourEntity(
                "РОСТОВ-НА-ДОНУ - БАТЮШКА ДОН 6 дней", "Ростов-на-Дону",
                "Набережная, Театральная площадь, станица Старочеркасская, Таганрог",
                "6 дней/5 ночей", 35, 35900.0,
                parseDate("2025-09-10"), parseDate("2025-09-16"), true,
                TourType.EXCURSION, TourIntensity.Usual,
                List.of(flightToRostov1, flightToRostov2, flightFromRostov1, flightFromRostov2),
                List.of(hotelRostov1, hotelRostov2)
        );

        // Тур 17: Волгоград - Город-герой
        TourEntity tour17 = new TourEntity(
                "ВОЛГОГРАД - СТАЛИНГРАДСКАЯ БИТВА 6 дней", "Волгоград",
                "Мамаев курган, Родина-мать, мельница Гергардта, панорама Сталинградской битвы",
                "6 дней/5 ночей", 40, 32900.0,
                parseDate("2025-08-20"), parseDate("2025-08-26"), true,
                TourType.EXCURSION, TourIntensity.Usual,
                List.of(flightToVolgograd1, flightToVolgograd2, flightFromVolgograd1, flightFromVolgograd2),
                List.of(hotelVolgograd1, hotelVolgograd2)
        );

        // Тур 18: Самара - Космическая столица
        TourEntity tour18 = new TourEntity(
                "САМАРА - КОСМИЧЕСКАЯ 5 дней", "Самара",
                "Музей космонавтики, бункер Сталина, ракета Союз, набережная Волги",
                "5 дней/4 ночи", 40, 26900.0,
                parseDate("2025-09-25"), parseDate("2025-09-30"), true,
                TourType.EXCURSION, TourIntensity.Passive,
                List.of(flightToSamara1, flightToSamara2, flightFromSamara1, flightFromSamara2),
                List.of(hotelSamara1, hotelSamara2)
        );

        // Тур 19: Золотое кольцо (через Москву)
        TourEntity tour19 = new TourEntity(
                "ЗОЛОТОЕ КОЛЬЦО - РУСЬ ИСКОННАЯ 8 дней", "Москва",
                "Сергиев Посад, Суздаль, Владимир, Ярославль, Кострома, Переславль-Залесский",
                "8 дней/7 ночей", 30, 65900.0,
                parseDate("2025-08-01"), parseDate("2025-08-09"), true,
                TourType.EXCURSION, TourIntensity.Active,
                List.of(flightToMoscow1, flightToMoscow3, flightFromMoscow1, flightFromMoscow3),
                List.of(hotelMoscow1, hotelMoscow2)
        );

        // Тур 20: Дагестан - Кавказ гостеприимный
        TourEntity tour20 = new TourEntity(
                "ДАГЕСТАН - КАВКАЗСКИЙ ДУХ 8 дней", "Дагестан",
                "Сулакский каньон, бархан Сарыкум, Дербент, Чох, Гамсутль, озеро Казеной-Ам",
                "8 дней/7 ночей", 30, 59800.0,
                parseDate("2025-07-20"), parseDate("2025-07-28"), true,
                TourType.SPORTS, TourIntensity.Active,
                List.of(flightToKrasnodar1, flightToKrasnodar2, flightFromKrasnodar1, flightFromKrasnodar2),
                List.of(hotelKrasnodar1, hotelKrasnodar2)
        );

        tourRepository.saveAll(List.of(
                tour1, tour2, tour3, tour4, tour5, tour6, tour7, tour8, tour9, tour10,
                tour11, tour12, tour13, tour14, tour15, tour16, tour17, tour18, tour19, tour20
        ));
    }

    private Date parseDate(String dateString) {
        try {
            java.text.SimpleDateFormat sdf;
            if (dateString.contains(":")) {
                sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            } else {
                sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
            }
            return sdf.parse(dateString);
        } catch (java.text.ParseException e) {
            throw new RuntimeException("Ошибка парсинга даты: " + dateString, e);
        }
    }
}