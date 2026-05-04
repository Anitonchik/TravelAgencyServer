package com.example.TravelAgencyServer.api.manager;

import com.example.TravelAgencyServer.entity.manager.ManagerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ManagerMapper {
    @Mapping(target = "id", ignore = true)
    ManagerEntity RqToEntity(ManagerRq dto);

    @Mapping(target = "id", ignore = true)
    ManagerEntity updateEntity(ManagerRq dto, @MappingTarget ManagerEntity entity);

    ManagerRs EntityToRs(ManagerEntity dto);

    List<ManagerRs> ListEntitiesToListRq(List<ManagerEntity> entities);
}
