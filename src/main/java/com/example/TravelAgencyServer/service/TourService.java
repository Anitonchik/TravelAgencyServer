package com.example.TravelAgencyServer.service;

import com.example.TravelAgencyServer.api.flight.FlightMapper;
import com.example.TravelAgencyServer.api.flight.FlightRs;
import com.example.TravelAgencyServer.api.hotel.HotelMapper;
import com.example.TravelAgencyServer.api.tour.TourMainInfoRs;
import com.example.TravelAgencyServer.api.tour.TourMapper;
import com.example.TravelAgencyServer.api.tour.TourRq;
import com.example.TravelAgencyServer.api.tour.TourRs;
import com.example.TravelAgencyServer.entity.flight.FlightEntity;
import com.example.TravelAgencyServer.entity.tour.TourEntity;
import com.example.TravelAgencyServer.exceptions.EntityNotExistsException;
import com.example.TravelAgencyServer.repository.TourRepository;
import org.antlr.v4.runtime.misc.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class TourService {
    @Autowired
    private TourRepository repository;

    @Autowired
    private TourMapper mapper;

    @Transactional
    public TourEntity findById(Long id) {
        var entity = repository.findById(id);
        if (entity.isPresent()) {
            return entity.get();
        }
        else {
            throw new EntityNotExistsException(id, "Тура не существует");
        }
    }

    @Transactional(readOnly = true)
    public TourRs getById(Long id) {
        var entity = repository.findById(id);
        if (entity.isPresent()) {
            return mapTour(entity.get());
        }
        else {
            throw new EntityNotExistsException(id, "Тура не существует");
        }
    }

    @Transactional(readOnly = true)
    public Page<TourRs> getAll(int pageNumber, int pageSize) {
        return repository.findAll(PageRequest.of(pageNumber, pageSize)).map(this::mapTour);
    }

    @Transactional(readOnly = true)
    public Page<TourRs> getByDirection(String direction, int pageNumber, int pageSize) {
        return repository.findByDirectionContainingIgnoreCase(direction, PageRequest.of(pageNumber, pageSize))
                .map(this::mapTour);
    }

    @Transactional(readOnly = true)
    public Page<TourRs> getByDates(LocalDateTime dateFrom, LocalDateTime dateTo, int pageNumber, int pageSize) {
        return repository.findByDateFromAndDateTo(dateFrom, dateTo, PageRequest.of(pageNumber, pageSize)).map(this::mapTour);
    }

    @Transactional(readOnly = true)
    public Page<TourRs> getByHotel(String hotelName, int pageNumber, int pageSize) {
        return repository
                .findByHotels_NameContainingIgnoreCase(hotelName, PageRequest.of(pageNumber, pageSize))
                .map(this::mapTour);
    }

    @Transactional(readOnly = true)
    public Page<TourRs> getByPrice(Double priceStart, Double priceEnd, int pageNumber, int pageSize) {
        return repository.findByPriceBetween(priceStart, priceEnd, PageRequest.of(pageNumber, pageSize)).map(this::mapTour);
    }

    public TourRs mapTour(TourEntity entity) {
        var tourFlights = entity.getFlights();
        var hotels = entity.getHotels();

        List<FlightEntity> flightsTo = new ArrayList<>();
        List<FlightEntity> flightsFrom = new ArrayList<>();
        for (var flight : tourFlights){
            if (Objects.equals(flight.getLocationFrom(), "Ульяновск")){
                flightsTo.add(flight);
            }
            else {
                flightsFrom.add(flight);
            }
        }
        return mapper.EntityToRs(entity, flightsTo, flightsFrom, hotels);
    }


    /*@Transactional
    public TourRs create(TourRq dto) {
        var entity = repository.save(mapper.RqToEntity(dto));
        return mapper.EntityToRs(entity);
    }

    @Transactional
    public TourRs update(TourRq dto, Long id) {
        var entity = findById(id);
        var updatedEntity = mapper.updateEntity(dto, entity);
        return mapper.EntityToRs(updatedEntity);
    }

    @Transactional
    public boolean delete(Long id){
        repository.findById(id).ifPresent(clientEntity -> repository.delete(clientEntity));
        return repository.existsById(id);
    }*/
}

/*
 @Transactional(readOnly = true)
    public TourRs getById(Long id) {
        var entity = repository.findById(id);
        if (entity.isPresent()) {
            var tour = entity.get();
            var tourFlights = flightMapper.ListEntitiesToListRs(tour.getFlights());
            var hotels = hotelMapper.ListEntitiesToListRs(tour.getHotels());

            List<FlightRs> flightsTo = new ArrayList<>();
            List<FlightRs> flightsFrom = new ArrayList<>();
            for (var flight : tourFlights){
                if (Objects.equals(flight.locationFrom(), "Ульяновск")){
                    flightsTo.add(flight);
                }
                else {
                    flightsFrom.add(flight);
                }
            }

            return mapper.EntityToRs(tour, flightsTo, flightsFrom, hotels);
        }
        else {
            throw new EntityNotExistsException(id, "Тура не существует");
        }
    }
 */
