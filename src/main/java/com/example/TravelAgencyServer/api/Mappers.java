package com.example.TravelAgencyServer.api;

import com.example.TravelAgencyServer.entity.client.ClientEntity;
import com.example.TravelAgencyServer.service.CipherService;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface Mappers {
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "snils", expression = "java(cipherService.encryptData(clientRq.snils()))")
    })
    ClientEntity ClientRqToClientEntity(ClientRq clientRq, @Context CipherService cipherService);

    @Mapping(target = "snils", expression = "java(cipherService.decryptData(clientEntity.getSnils()))")
    ClientRs ClientEntityToClientRs(ClientEntity clientEntity, @Context CipherService cipherService);

    List<ClientRs> ClientEntityListToClientRsList(List<ClientEntity> clientEntities, @Context CipherService cipherService);


    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "snils", expression = "java(cipherService.encryptData(clientRq.snils()))")
    })
    ClientEntity UpdateClientRqToClientEntity(ClientRq clientRq, @MappingTarget ClientEntity entity, @Context CipherService cipherService);
}
