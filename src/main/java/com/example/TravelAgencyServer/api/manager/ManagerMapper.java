package com.example.TravelAgencyServer.api.manager;

import com.example.TravelAgencyServer.entity.manager.ManagerEntity;
import org.mapstruct.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ManagerMapper {
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "password", expression = "java(pswEnc.encode(dto.password()))")
    })

    ManagerEntity RqToEntity(ManagerRq dto, @Context PasswordEncoder pswEnc);

    @Mapping(target = "id", ignore = true)
    ManagerEntity updateEntity(ManagerRq dto, @MappingTarget ManagerEntity entity);

    ManagerRs EntityToRs(ManagerEntity dto);

    List<ManagerRs> ListEntitiesToListRq(List<ManagerEntity> entities);
}
