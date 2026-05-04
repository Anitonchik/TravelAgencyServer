package com.example.TravelAgencyServer.service;

import com.example.TravelAgencyServer.api.flight.FlightMapper;
import com.example.TravelAgencyServer.api.flight.FlightRq;
import com.example.TravelAgencyServer.api.flight.FlightRs;
import com.example.TravelAgencyServer.api.hotel.HotelRq;
import com.example.TravelAgencyServer.entity.flight.FlightEntity;
import com.example.TravelAgencyServer.exceptions.EntityNotExistsException;
import com.example.TravelAgencyServer.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FlightService {
    @Autowired
    private FlightRepository repository;

    @Autowired
    private FlightMapper mapper;

    @Transactional
    public FlightEntity findById(Long id) {
        var entity = repository.findById(id);
        if (entity.isPresent()) {
            return entity.get();
        }
        else {
            throw new EntityNotExistsException(id, "Отеля не существует");
        }
    }

    @Transactional(readOnly = true)
    public FlightRs getById(Long id) {
        var entity = repository.findById(id);
        if (entity.isPresent()) {
            return mapper.EntityToRs(entity.get());
        }
        else {
            throw new EntityNotExistsException(id, "Отеля не существует");
        }
    }

    @Transactional(readOnly = true)
    public List<FlightRs> getAll() {
        return mapper.ListEntitiesToListRq(repository.findAll());
    }

    @Transactional
    public FlightRs create(FlightRq dto) {
        var entity = repository.save(mapper.RqToEntity(dto));
        return mapper.EntityToRs(entity);
    }

    @Transactional
    public FlightRs update(FlightRq dto, Long id) {
        var entity = findById(id);
        var updatedEntity = mapper.updateEntity(dto, entity);
        return mapper.EntityToRs(updatedEntity);
    }

    @Transactional
    public boolean delete(Long id){
        repository.findById(id).ifPresent(clientEntity -> repository.delete(clientEntity));
        return repository.existsById(id);
    }
}
