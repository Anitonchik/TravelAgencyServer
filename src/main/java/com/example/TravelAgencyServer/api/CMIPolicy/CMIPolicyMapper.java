package com.example.TravelAgencyServer.api.CMIPolicy;

import com.example.TravelAgencyServer.api.client.ClientMappers;
import com.example.TravelAgencyServer.entity.client.CMIPolicyEntity;
import com.example.TravelAgencyServer.service.CipherService;
import com.example.TravelAgencyServer.service.ClientService;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CMIPolicyMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "client", expression = "java(clientService.findById(dto.clientId()))"),
            @Mapping(target = "CMIPolicy", expression = "java(cipherService.encryptData(dto.CMIPolicy()))"),
            @Mapping(target = "image", expression = "java(cipherService.encryptData(dto.image()))")
    })
    CMIPolicyEntity RqToEntity(CMIPolicyRq dto, @Context ClientService clientService,
                               @Context CipherService cipherService);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "client", ignore = true),
            @Mapping(target = "CMIPolicy", expression = "java(cipherService.encryptData(rq.CMIPolicy()))"),
            @Mapping(target = "image", expression = "java(cipherService.encryptData(rq.image()))")
    })
    CMIPolicyEntity updateEntity(CMIPolicyWithoutClientRq rq, @MappingTarget CMIPolicyEntity entity,
                                 @Context CipherService cipherService);


    @Mappings({
            @Mapping(target = "client", expression = "java(clientMappers.ClientEntityToClientRs(entity.getClient(), cipherService))"),
            @Mapping(target = "CMIPolicy", expression = "java(cipherService.decryptData(entity.getCMIPolicy()))"),
            @Mapping(target = "image", expression = "java(cipherService.decryptData(entity.getImage()))")
    })
    CMIPolicyRs EntityToRs(CMIPolicyEntity entity, @Context ClientMappers clientMappers,
                                @Context CipherService cipherService);

    List<CMIPolicyRs> ListEntityToListRs(List<CMIPolicyEntity> entities, @Context ClientMappers clientMappers,
                                              @Context CipherService cipherService);
}
