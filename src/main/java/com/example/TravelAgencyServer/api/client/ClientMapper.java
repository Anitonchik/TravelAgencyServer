package com.example.TravelAgencyServer.api.client;

import com.example.TravelAgencyServer.entity.client.ClientEntity;
import com.example.TravelAgencyServer.entity.client.ClientPassportCMIPolicy;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClientMapper {
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "snils", ignore = true)
    })
    ClientEntity ClientRqToClientEntity(ClientRq clientRq);

    @Mapping(target = "snils", ignore = true)
    ClientRs ClientEntityToClientRs(ClientEntity clientEntity);

    @Mappings({
            @Mapping(target = "snils", ignore = true),
            @Mapping(target = "passport.series", ignore = true),
            @Mapping(target = "passport.numbers", ignore = true),
            @Mapping(target = "passport.image", ignore = true),
            @Mapping(target = "policy.CMIPolicy", ignore = true),
            @Mapping(target = "policy.image", ignore = true),
    })
    ClientRs ClientPassportCMIPolicyEntityToClientRs(ClientPassportCMIPolicy clientEntity);

    List<ClientRs> ClientEntityListToClientRsList(List<ClientPassportCMIPolicy> clientEntities);


    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "snils", ignore = true)
    })
    ClientEntity UpdateClientRqToClientEntity(ClientRq clientRq, @MappingTarget ClientEntity entity);
}
