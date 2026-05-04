package com.example.TravelAgencyServer.api.client;

import com.example.TravelAgencyServer.api.CMIPolicy.CMIPolicyMapper;
import com.example.TravelAgencyServer.api.clientPassport.ClientPassportMapper;
import com.example.TravelAgencyServer.entity.client.ClientEntity;
import com.example.TravelAgencyServer.service.CipherService;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClientMappers {
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "snils", expression = "java(cipherService.encryptData(clientRq.snils()))"),
    })
    ClientEntity ClientRqToClientEntity(ClientRq clientRq, @Context CipherService cipherService);

    @Mapping(target = "snils", expression = "java(cipherService.decryptData(clientEntity.getSnils()))")
    ClientRs ClientEntityToClientRs(ClientEntity clientEntity, @Context CipherService cipherService);

    @Mappings({
            @Mapping(target = "snils", expression = "java(cipherService.decryptData(clientEntity.getSnils()))"),
            @Mapping(target = "passport", expression = "java(clientPassportMapper.EntityToRs(clientEntity.getPassport()))"),
            @Mapping(target = "policy", expression = "java(cmiPolicyMapper.EntityToRs(clientEntity.getPolicy()))"),
    })
    ClientRs ClientPassportCMIPolicyEntityToClientRs(ClientPassportCMIPolicyEntity clientEntity,
                                                     @Context CipherService cipherService,
                                                     @Context ClientPassportMapper clientPassportMapper,
                                                     @Context CMIPolicyMapper cmiPolicyMapper);


    List<ClientRs> ClientEntityListToClientRsList(List<ClientPassportCMIPolicyEntity> clientEntities,
                                                  @Context CipherService cipherService,
                                                  @Context ClientPassportMapper clientPassportMapper,
                                                  @Context CMIPolicyMapper cmiPolicyMapper);


    @Mappings({
            @Mapping(target = "id", ignore = true),

            @Mapping(target = "snils", expression = "java(cipherService.encryptData(clientRq.snils()))")
    })
    ClientEntity UpdateClientRqToClientEntity(ClientRq clientRq, @MappingTarget ClientEntity entity, @Context CipherService cipherService);
}
