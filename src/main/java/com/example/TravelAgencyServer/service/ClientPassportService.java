package com.example.TravelAgencyServer.service;

import com.example.TravelAgencyServer.api.client.ClientMappers;
import com.example.TravelAgencyServer.api.clientPassport.ClientPassportMapper;
import com.example.TravelAgencyServer.api.clientPassport.ClientPassportRq;
import com.example.TravelAgencyServer.api.clientPassport.ClientPassportRs;
import com.example.TravelAgencyServer.api.clientPassport.ClientPassportWithoutClientRq;
import com.example.TravelAgencyServer.entity.client.ClientPassportEntity;
import com.example.TravelAgencyServer.exceptions.EntityNotExistsException;
import com.example.TravelAgencyServer.repository.ClientPassportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientPassportService {
    @Autowired
    private ClientPassportRepository repository;

    @Autowired
    private ClientPassportMapper mapper;

    @Autowired
    private ClientMappers clientMappers;
    
    @Autowired
    private ClientService clientService;

    @Autowired
    private CipherService cipherService;

    public ClientPassportEntity findById(Long id) {
        var entity =  repository.findById(id);
        if (entity.isPresent()) {
            return entity.get();
        }
        else throw new EntityNotExistsException(id);
    }

    public List<ClientPassportRs> getAll() {
        return mapper.ListEntityToListRs(repository.findAll(), clientMappers, cipherService);
    }

    public ClientPassportRs getById(Long id) {
        return mapper.EntityToRs(findById(id), clientMappers, cipherService);
    }
    
    public ClientPassportRs create(ClientPassportRq dto) {
        var entity = repository.save(mapper.RqToEntity(dto, clientService, cipherService));
        return mapper.EntityToRs(entity, clientMappers, cipherService);
    }
    
    public ClientPassportRs update(Long id, ClientPassportWithoutClientRq dto){
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
