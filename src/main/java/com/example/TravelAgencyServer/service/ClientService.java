package com.example.TravelAgencyServer.service;

import com.example.TravelAgencyServer.api.client.ClientMappers;
import com.example.TravelAgencyServer.api.client.ClientRq;
import com.example.TravelAgencyServer.api.client.ClientRs;
import com.example.TravelAgencyServer.entity.client.ClientEntity;
import com.example.TravelAgencyServer.exceptions.EntityNotExistsException;
import com.example.TravelAgencyServer.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;

    @Autowired
    private ClientMappers mapper;

    @Autowired
    private CipherService cipherService;

    @Transactional
    public ClientEntity findById(Long id) {
        var entity = repository.findById(id);
        if (entity.isPresent()) {
            return entity.get();
        }
        else {
            throw new EntityNotExistsException(id);
        }
    }

    @Transactional(readOnly = true)
    public ClientRs getById(Long id) {
        var entity = repository.findById(id);
        if (entity.isPresent()) {
            return mapper.ClientEntityToClientRs(entity.get(), cipherService);
        }
        else {
            throw new EntityNotExistsException(id);
        }
    }

    @Transactional(readOnly = true)
    public List<ClientRs> getAll() {
        return mapper.ClientEntityListToClientRsList(repository.findAll(), cipherService);

    }

    @Transactional
    public ClientRs create(ClientRq dto) {
        var entity = repository.save(mapper.ClientRqToClientEntity(dto, cipherService));
        return mapper.ClientEntityToClientRs(entity, cipherService);
    }

    @Transactional
    public ClientRs update(ClientRq dto, Long id) {
        var entity = findById(id);
        var updatedEntity = mapper.UpdateClientRqToClientEntity(dto, entity, cipherService);
        return mapper.ClientEntityToClientRs(updatedEntity, cipherService);
    }

    @Transactional
    public boolean delete(Long id){
        repository.findById(id).ifPresent(clientEntity -> repository.delete(clientEntity));
        return repository.existsById(id);
    }
}
