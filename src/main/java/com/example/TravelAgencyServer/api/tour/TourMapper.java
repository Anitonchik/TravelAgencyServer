package com.example.TravelAgencyServer.api.tour;

import com.example.TravelAgencyServer.api.flight.FlightMapper;
import com.example.TravelAgencyServer.api.hotel.HotelMapper;
import com.example.TravelAgencyServer.entity.flight.FlightEntity;
import com.example.TravelAgencyServer.entity.hotel.HotelEntity;
import com.example.TravelAgencyServer.entity.tour.TourEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
    uses={
            FlightMapper.class,
            HotelMapper.class
    })
public interface TourMapper {
    @Mapping(target = "id", ignore = true)
    TourEntity RqToEntity(TourRq dto);

    @Mapping(target = "id", ignore = true)
    TourEntity updateEntity(TourRq dto, @MappingTarget TourEntity entity);

    /*@Mappings({
            @Mapping(target = "flightsTo", expression = "java(flightsTo)"),
            @Mapping(target = "flightsFrom", expression = "java(flightsFrom)"),
            @Mapping(target = "hotels", expression = "java(hotels)")
    })*/
    TourRs EntityToRs(TourEntity dto, List<FlightEntity> flightsTo, List<FlightEntity> flightsFrom, List<HotelEntity> hotels);

    TourMainInfoRs EntityToRs(TourEntity dto);

    List<TourRs> ListEntitiesToListRq(List<TourEntity> entities);
}
