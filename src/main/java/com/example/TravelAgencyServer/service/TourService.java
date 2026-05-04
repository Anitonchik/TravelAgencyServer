package com.example.TravelAgencyServer.service;

import com.example.TravelAgencyServer.api.flight.FlightMapper;
import com.example.TravelAgencyServer.api.flight.FlightRs;
import com.example.TravelAgencyServer.api.hotel.HotelMapper;
import com.example.TravelAgencyServer.api.tour.TourMapper;
import com.example.TravelAgencyServer.api.tour.TourRq;
import com.example.TravelAgencyServer.api.tour.TourRs;
import com.example.TravelAgencyServer.entity.flight.FlightEntity;
import com.example.TravelAgencyServer.entity.tour.TourEntity;
import com.example.TravelAgencyServer.exceptions.EntityNotExistsException;
import com.example.TravelAgencyServer.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class TourService {
    @Autowired
    private TourRepository repository;

    @Autowired
    private TourMapper mapper;

    @Autowired
    private FlightMapper flightMapper;

    @Autowired
    private HotelMapper hotelMapper;

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

    @Transactional(readOnly = true)
    public List<TourRs> getAll() {
        return mapper.ListEntitiesToListRq(repository.findAll());
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
