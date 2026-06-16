package com.example.TravelAgencyServer.service;

import com.example.TravelAgencyServer.api.tour.TourMapper;
import com.example.TravelAgencyServer.api.tour.TourRs;
import com.example.TravelAgencyServer.entity.flight.FlightEntity;
import com.example.TravelAgencyServer.entity.tour.TourCity;
import com.example.TravelAgencyServer.entity.tour.TourEntity;
import com.example.TravelAgencyServer.exceptions.EntityNotExistsException;
import com.example.TravelAgencyServer.repository.ClientRepository;
import com.example.TravelAgencyServer.repository.TourRepository;
import com.example.TravelAgencyServer.repository.TourSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class TourService {
    @Autowired
    private TourRepository repository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private TourMapper mapper;

    @Transactional
    public TourEntity findById(Long id) {
        var entity = repository.findById(id);
        if (entity.isPresent()) {
            return entity.get();
        } else {
            throw new EntityNotExistsException(id, "Тура не существует");
        }
    }

    @Transactional(readOnly = true)
    public TourRs getById(Long id) {
        var entity = repository.findById(id);
        if (entity.isPresent()) {
            return mapTour(entity.get());
        } else {
            throw new EntityNotExistsException(id, "Тура не существует");
        }
    }

    @Transactional(readOnly = true)
    public Page<TourRs> getAll(int pageNumber, int pageSize) {
        return repository.findAll(PageRequest.of(pageNumber, pageSize)).map(this::mapTour);
    }

    @Transactional(readOnly = true)
    public Page<TourRs> getByClientPreferences(Long clientId, int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        var client = clientRepository.findById(clientId)
                .orElseThrow(() -> new EntityNotExistsException(clientId, "При получении предпочтений нет клиента"));

        return repository
                .findByDirectionAndDateFromGreaterThanEqualAndPriceBetween(
                        client.getPreferenceCity(),
                        client.getPreferenceDateFrom(),
                        client.getPreferencePriceFrom(),
                        client.getPreferencePriceTo(),
                        PageRequest.of(pageNumber, pageSize))
                .map(this::mapTour);
        /*return repository.findByDirectionAndDateFromGreaterThanEqualAndPriceGreaterThanEqualAndPriceLessThanEqual(
                client.getPreferenceCity(), client.getPreferenceDateFrom(), client.getPreferencePriceFrom(),
                client.getPreferencePriceTo(), pageable).map(this::mapTour);*/
    }

    @Transactional(readOnly = true)
    public Page<TourRs> searchTours(String direction, LocalDateTime dateFrom, LocalDateTime dateTo,
                                    Double priceFrom, Double priceTo, String hotelName,
                                    int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        return repository
                .findAll(TourSpecifications.searchTours(direction, dateFrom, dateTo, priceFrom, priceTo, hotelName), pageable)
                .map(this::mapTour);
        //return repository.searchTours(direction, dateFrom, dateTo, priceFrom, priceTo, hotelName, pageable).map(this::mapTour);
    }



    public TourRs mapTour(TourEntity entity) {
        var tourFlights = entity.getFlights();
        var hotels = entity.getHotels();

        List<FlightEntity> flightsTo = new ArrayList<>();
        List<FlightEntity> flightsFrom = new ArrayList<>();
        for (var flight : tourFlights) {
            if (Objects.equals(flight.getLocationFrom(), "Ульяновск")) {
                flightsTo.add(flight);
            } else {
                flightsFrom.add(flight);
            }
        }
        return mapper.EntityToRs(entity, flightsTo, flightsFrom, hotels);
    }
}