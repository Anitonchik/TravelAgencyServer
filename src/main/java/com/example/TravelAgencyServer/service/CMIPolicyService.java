package com.example.TravelAgencyServer.service;

import com.example.TravelAgencyServer.api.CMIPolicy.CMIPolicyMapper;
import com.example.TravelAgencyServer.api.CMIPolicy.CMIPolicyRq;
import com.example.TravelAgencyServer.api.CMIPolicy.CMIPolicyRs;
import com.example.TravelAgencyServer.api.CMIPolicy.CMIPolicyWithoutClientRq;
import com.example.TravelAgencyServer.api.client.ClientMappers;
import com.example.TravelAgencyServer.entity.client.CMIPolicyEntity;
import com.example.TravelAgencyServer.exceptions.EntityNotExistsException;
import com.example.TravelAgencyServer.repository.CMIPolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CMIPolicyService {
    @Autowired
    private CMIPolicyRepository repository;

    @Autowired
    private CMIPolicyMapper mapper;

    @Autowired
    private ClientMappers clientMappers;

    @Autowired
    private ClientService clientService;

    @Autowired
    private CipherService cipherService;

    public CMIPolicyEntity findById(Long id) {
        var entity =  repository.findById(id);
        if (entity.isPresent()) {
            return entity.get();
        }
        else throw new EntityNotExistsException(id);
    }

    public List<CMIPolicyRs> getAll() {
        return mapper.ListEntityToListRs(repository.findAll(), clientMappers, cipherService);
    }

    public CMIPolicyRs getById(Long id) {
        return mapper.EntityToRs(findById(id), clientMappers, cipherService);
    }

    public CMIPolicyRs create(CMIPolicyRq dto) {
        var entity = repository.save(mapper.RqToEntity(dto, clientService, cipherService));
        return mapper.EntityToRs(entity, clientMappers, cipherService);
    }

    public CMIPolicyRs update(Long id, CMIPolicyWithoutClientRq dto){
        var entity = findById(id);
        entity = mapper.updateEntity(dto, entity, cipherService);
        return mapper.EntityToRs(entity, clientMappers, cipherService);
    }

    public boolean delete(Long id){
        var entity = findById(id);
        repository.delete(entity);
        return repository.existsById(id);
    }
}
