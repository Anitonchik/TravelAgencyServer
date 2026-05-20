package com.example.TravelAgencyServer.service;

import com.example.TravelAgencyServer.api.hotel.HotelMapper;
import com.example.TravelAgencyServer.api.hotel.HotelRq;
import com.example.TravelAgencyServer.api.hotel.HotelRs;
import com.example.TravelAgencyServer.api.tour.TourMapper;
import com.example.TravelAgencyServer.api.tour.TourRq;
import com.example.TravelAgencyServer.api.tour.TourRs;
import com.example.TravelAgencyServer.entity.hotel.HotelEntity;
import com.example.TravelAgencyServer.entity.tour.TourEntity;
import com.example.TravelAgencyServer.exceptions.EntityNotExistsException;
import com.example.TravelAgencyServer.repository.HotelRepository;
import com.example.TravelAgencyServer.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HotelService {
    @Autowired
    private HotelRepository repository;

    @Autowired
    private HotelMapper mapper;

    @Transactional
    public HotelEntity findById(Long id) {
        var entity = repository.findById(id);
        if (entity.isPresent()) {
            return entity.get();
        }
        else {
            throw new EntityNotExistsException(id, "Отеля не существует");
        }
    }

    @Transactional(readOnly = true)
    public HotelRs getById(Long id) {
        var entity = repository.findById(id);
        if (entity.isPresent()) {
            return mapper.EntityToRs(entity.get());
        }
        else {
            throw new EntityNotExistsException(id, "Отеля не существует");
        }
    }

    @Transactional(readOnly = true)
    public List<HotelRs> getAll() {
        return mapper.ListEntitiesToListRs(repository.findAll());
    }


    @Transactional
    public HotelRs create(HotelRq dto) {
        var entity = repository.save(mapper.RqToEntity(dto));
        return mapper.EntityToRs(entity);
    }

    @Transactional
    public HotelRs update(HotelRq dto, Long id) {
        var entity = findById(id);
        var updatedEntity = mapper.updateEntity(dto, entity);
        return mapper.EntityToRs(updatedEntity);
    }

    @Transactional
    public boolean delete(Long id){
        repository.findById(id).ifPresent(clientEntity -> repository.delete(clientEntity));
        return repository.existsById(id);
    }

    public HotelRs entityToRs(HotelEntity entity){
        return mapper.EntityToRs(entity);
    }
}
