package com.example.TravelAgencyServer.service;

import com.example.TravelAgencyServer.api.CMIPolicy.CMIPolicyMapper;
import com.example.TravelAgencyServer.api.CMIPolicy.CMIPolicyRq;
import com.example.TravelAgencyServer.entity.client.CMIPolicyEntity;
import com.example.TravelAgencyServer.exceptions.EntityNotExistsException;
import com.example.TravelAgencyServer.repository.CMIPolicyRepository;
import com.example.TravelAgencyServer.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CMIPolicyService {
    @Autowired
    private CMIPolicyRepository repository;

    @Autowired
    private CMIPolicyMapper mapper;

    /*@Autowired
    private ClientMappers clientMappers;*/

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CipherService cipherService;

    public CMIPolicyEntity findById(Long id) {
        var entity =  repository.findById(id);
        if (entity.isPresent()) {
            return entity.get();
        }
        else throw new EntityNotExistsException(id, "Полис не существует");
    }

    /*public List<CMIPolicyRs> getAll() {
        return mapper.ListEntityToListRs(repository.findAll(), clientMappers, cipherService);
    }

    public CMIPolicyRs getById(Long id) {
        return mapper.EntityToRs(findById(id), clientMappers, cipherService);
    }*/

    public CMIPolicyEntity create(CMIPolicyRq dto) {
        var entity = mapper.RqToEntity(dto, cipherService);
        var client = clientRepository.findById(dto.clientId());
        if (client.isPresent()){
            entity.setClient(client.get());
            return repository.save(entity);
        }
        throw new EntityNotExistsException(dto.clientId(), "При создании полиса клиент под id е существует");
    }

    public CMIPolicyEntity update(Long clientId, CMIPolicyRq dto){
        var entity = repository.findByClient_IdAndIsActiveTrue(clientId).getFirst();
        entity.setActive(false);
        repository.save(entity);
        return create(dto);
    }

    public boolean delete(Long id){
        var entity = findById(id);
        entity.setActive(false);
        repository.save(entity);
        return true;
    }
}
