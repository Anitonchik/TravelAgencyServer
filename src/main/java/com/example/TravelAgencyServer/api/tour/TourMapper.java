package com.example.TravelAgencyServer.api.tour;

import com.example.TravelAgencyServer.api.flight.FlightRs;
import com.example.TravelAgencyServer.api.hotel.HotelRs;
import com.example.TravelAgencyServer.entity.tour.TourEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TourMapper {
    @Mapping(target = "id", ignore = true)
    TourEntity RqToEntity(TourRq dto);

    @Mapping(target = "id", ignore = true)
    TourEntity updateEntity(TourRq dto, @MappingTarget TourEntity entity);

    @Mappings({
            @Mapping(target = "flightsTo", expression = "java(flightsTo)"),
            @Mapping(target = "flightsFrom", expression = "java(flightsFrom)"),
            @Mapping(target = "hotels", expression = "java(hotels)")
    })
    TourRs EntityToRs(TourEntity dto, List<FlightRs> flightsTo, List<FlightRs> flightsFrom, List<HotelRs> hotels);

    List<TourRs> ListEntitiesToListRq(List<TourEntity> entities);
}
