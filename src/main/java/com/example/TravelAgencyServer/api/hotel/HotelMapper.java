package com.example.TravelAgencyServer.api.hotel;

import com.example.TravelAgencyServer.entity.hotel.HotelEntity;
import com.example.TravelAgencyServer.service.TourService;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface HotelMapper {
    @Mapping(target = "id", ignore = true)
    HotelEntity RqToEntity(HotelRq dto);

    @Mapping(target = "id", ignore = true)
    HotelEntity updateEntity(HotelRq dto, @MappingTarget HotelEntity entity);

    HotelRs EntityToRs(HotelEntity dto);

    List<HotelRs> ListEntitiesToListRs(List<HotelEntity> entities);
}
