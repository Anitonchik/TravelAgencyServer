package com.example.TravelAgencyServer.api.reservation;

import com.example.TravelAgencyServer.api.client.ClientMapper;
import com.example.TravelAgencyServer.api.hotel.HotelMapper;
import com.example.TravelAgencyServer.api.manager.ManagerMapper;
import com.example.TravelAgencyServer.api.tour.TourMapper;
import com.example.TravelAgencyServer.entity.client.ClientEntity;
import com.example.TravelAgencyServer.entity.flight.FlightEntity;
import com.example.TravelAgencyServer.entity.hotel.HotelEntity;
import com.example.TravelAgencyServer.entity.manager.ManagerEntity;
import com.example.TravelAgencyServer.entity.reservation.ReservationEntity;
import com.example.TravelAgencyServer.entity.tour.TourEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
uses = {
        ManagerMapper.class,
        ClientMapper.class,
        TourMapper.class,
        HotelMapper.class
})
public interface ReservationMapper {
    @Mapping(target = "id", ignore = true)
    ReservationEntity RqToEntity(ReservationRq dto, ManagerEntity manager, ClientEntity client,
                                 TourEntity tour, FlightEntity flightFrom, FlightEntity flightTo, HotelEntity hotel);

    @Mapping(target = "id", ignore = true)
    ReservationEntity updateEntity(ReservationRq dto, @MappingTarget ReservationEntity entity, ManagerEntity manager,
                                   ClientEntity client, TourEntity tour, FlightEntity flightFrom,
                                   FlightEntity flightTo, HotelEntity hotel);

    ReservationRs EntityToRs(ReservationEntity dto);

    List<ReservationRs> ListEntitiesToListRq(List<ReservationEntity> entities);
}
