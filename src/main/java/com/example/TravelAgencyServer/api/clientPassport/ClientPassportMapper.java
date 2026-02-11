package com.example.TravelAgencyServer.api.clientPassport;

import com.example.TravelAgencyServer.api.client.ClientMappers;
import com.example.TravelAgencyServer.entity.client.ClientPassportEntity;
import com.example.TravelAgencyServer.service.CipherService;
import com.example.TravelAgencyServer.service.ClientService;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClientPassportMapper {
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "client", expression = "java(clientService.findById(rq.clientId()))"),
            @Mapping(target = "series", expression = "java(cipherService.encryptData(rq.series()))"),
            @Mapping(target = "numbers", expression = "java(cipherService.encryptData(rq.numbers()))"),
            @Mapping(target = "image", expression = "java(cipherService.encryptData(rq.image()))")
    })
    ClientPassportEntity RqToEntity(ClientPassportRq rq, @Context ClientService clientService,
                                    @Context CipherService cipherService);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "series", expression = "java(cipherService.encryptData(rq.series()))"),
            @Mapping(target = "numbers", expression = "java(cipherService.encryptData(rq.numbers()))"),
            @Mapping(target = "image", expression = "java(cipherService.encryptData(rq.image()))")
    })
    ClientPassportEntity updateEntity(ClientPassportWithoutClientRq rq, @MappingTarget ClientPassportEntity entity,
                                      @Context CipherService cipherService);


    @Mappings({
            @Mapping(target = "client", expression = "java(clientMappers.ClientEntityToClientRs(entity.getClient(), cipherService))"),
            @Mapping(target = "series", expression = "java(cipherService.decryptData(entity.getSeries()))"),
            @Mapping(target = "numbers", expression = "java(cipherService.decryptData(entity.getNumbers()))"),
            @Mapping(target = "image", expression = "java(cipherService.decryptData(entity.getImage()))")
    })
    ClientPassportRs EntityToRs(ClientPassportEntity entity, @Context ClientMappers clientMappers,
                                    @Context CipherService cipherService);

    List<ClientPassportRs> ListEntityToListRs(List<ClientPassportEntity> entities, @Context ClientMappers clientMappers,
                                              @Context CipherService cipherService);
}
