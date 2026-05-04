package com.example.TravelAgencyServer.api.flight;

import com.example.TravelAgencyServer.entity.flight.FlightEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface FlightMapper {
    @Mapping(target = "id", ignore = true)
    FlightEntity RqToEntity(FlightRq dto);

    @Mapping(target = "id", ignore = true)
    FlightEntity updateEntity(FlightRq dto, @MappingTarget FlightEntity entity);


    FlightRs EntityToRs(FlightEntity dto);

    List<FlightRs> ListEntitiesToListRs(List<FlightEntity> entities);
}
