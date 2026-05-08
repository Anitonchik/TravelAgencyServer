package com.example.TravelAgencyServer.service;

import com.example.TravelAgencyServer.api.reservation.ReservationMapper;
import com.example.TravelAgencyServer.api.reservation.ReservationRq;
import com.example.TravelAgencyServer.api.reservation.ReservationRs;
import com.example.TravelAgencyServer.entity.reservation.ReservationEntity;
import com.example.TravelAgencyServer.exceptions.EntityNotExistsException;
import com.example.TravelAgencyServer.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository repository;

    @Autowired
    private ReservationMapper mapper;

    @Autowired
    private ManagerService managerService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private TourService tourService;

    @Autowired
    private FlightService flightService;

    @Autowired
    private HotelService hotelService;

    @Transactional
    public ReservationEntity findById(Long id) {
        var entity = repository.findById(id);
        if (entity.isPresent()) {
            return entity.get();
        }
        else {
            throw new EntityNotExistsException(id, "Менеджера не существует");
        }
    }

    @Transactional(readOnly = true)
    public ReservationRs getById(Long id) {
        var entity = repository.findById(id);
        if (entity.isPresent()) {
            return mapper.EntityToRs(entity.get());
        }
        else {
            throw new EntityNotExistsException(id, "Менеджера не существует");
        }
    }

    @Transactional(readOnly = true)
    public List<ReservationRs> getAll() {
        return mapper.ListEntitiesToListRq(repository.findAll());
    }

    @Transactional
    public ReservationRs create(ReservationRq dto) {
        var manager = managerService.findById(dto.managerId());
        var client = clientService.findById(dto.clientId());
        var tour = tourService.findById(dto.tourId());
        var flightFrom = flightService.findById(dto.flightFromId());
        var flightTo = flightService.findById(dto.flightToId());
        var hotel = hotelService.findById(dto.hotelId());
        var entity = repository.save(mapper.RqToEntity(dto, manager, client, tour, flightFrom, flightTo, hotel));
        return mapper.EntityToRs(entity);
    }

    @Transactional
    public ReservationRs update(ReservationRq dto, Long id) {
        var entity = findById(id);
        var manager = managerService.findById(dto.managerId());
        var client = clientService.findById(dto.clientId());
        var tour = tourService.findById(dto.tourId());
        var flightFrom = flightService.findById(dto.flightFromId());
        var flightTo = flightService.findById(dto.flightToId());
        var hotel = hotelService.findById(dto.hotelId());
        var updatedEntity = mapper.updateEntity(dto, entity, manager, client, tour, flightFrom, flightTo, hotel);
        return mapper.EntityToRs(updatedEntity);
    }

    @Transactional
    public boolean delete(Long id){
        repository.findById(id).ifPresent(clientEntity -> repository.delete(clientEntity));
        return repository.existsById(id);
    }
}
