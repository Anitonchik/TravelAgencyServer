package com.example.TravelAgencyServer.service;

import com.example.TravelAgencyServer.api.CMIPolicy.CMIPolicyMapper;
import com.example.TravelAgencyServer.api.CMIPolicy.CMIPolicyRq;
import com.example.TravelAgencyServer.api.client.ClientMappers;
import com.example.TravelAgencyServer.api.client.ClientRq;
import com.example.TravelAgencyServer.api.client.ClientRs;
import com.example.TravelAgencyServer.api.clientPassport.ClientPassportMapper;
import com.example.TravelAgencyServer.api.clientPassport.ClientPassportRq;
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

    @Autowired
    private ClientPassportService clientPassportService;

    @Autowired
    private CMIPolicyService cmiPolicyService;

    @Autowired
    private ClientPassportMapper clientPassportMapper;

    @Autowired
    private CMIPolicyMapper cmiPolicyMapper;


    @Transactional
    public ClientEntity findById(Long id) {
        var entity = repository.findById(id);
        if (entity.isPresent()) {
            return entity.get();
        }
        else {
            throw new EntityNotExistsException(id, "Клиента не существует");
        }
    }

    @Transactional(readOnly = true)
    public ClientRs getById(Long id) {
        var entity = repository.getClientPassportPolicy(id);
        if (entity.isPresent()) {
            return mapper.ClientPassportCMIPolicyEntityToClientRs(entity.get(), cipherService,
                    clientPassportMapper, cmiPolicyMapper);
        }
        else {
            throw new EntityNotExistsException(id, "Клиент не существует");
        }
    }

    @Transactional(readOnly = true)
    public List<ClientRs> getAll() {
        return mapper.ClientEntityListToClientRsList(repository.getAllClientPassportPolicy(), cipherService,
                clientPassportMapper, cmiPolicyMapper);

    }

    @Transactional
    public ClientRs create(ClientRq dto) {
        var entity = repository.save(mapper.ClientRqToClientEntity(dto, cipherService));

        var passportRq = new ClientPassportRq(entity.getId(), dto.passportSeries(), dto.passportNumbers(), dto.policyImage());
        clientPassportService.create(passportRq);

        var cmiPolicyRq = new CMIPolicyRq(entity.getId(), dto.policy(), dto.policyImage());
        cmiPolicyService.create(cmiPolicyRq);

        var newEntity = repository.getClientPassportPolicy(entity.getId());
        if (newEntity.isPresent()) {
            return mapper.ClientPassportCMIPolicyEntityToClientRs(newEntity.get(), cipherService, clientPassportMapper, cmiPolicyMapper);
        }
        throw new EntityNotExistsException(entity.getId(), "Клиента не существует");
    }

    @Transactional
    public ClientRs update(ClientRq dto, Long id) {
        var entity = findById(id);
        entity = mapper.UpdateClientRqToClientEntity(dto, entity, cipherService);

        var passportRq = new ClientPassportRq(entity.getId(), dto.passportSeries(), dto.passportNumbers(), dto.policyImage());
        clientPassportService.update(entity.getId(), passportRq);

        var cmiPolicyRq = new CMIPolicyRq(entity.getId(), dto.policy(), dto.policyImage());
        cmiPolicyService.update(entity.getId(), cmiPolicyRq);

        var newEntity = repository.getClientPassportPolicy(entity.getId());
        if (newEntity.isPresent()) {
            return mapper.ClientPassportCMIPolicyEntityToClientRs(newEntity.get(), cipherService, clientPassportMapper, cmiPolicyMapper);
        }
        throw new EntityNotExistsException(entity.getId(), "Клиента не существует");
    }

    @Transactional
    public boolean delete(Long id){
        var entity = findById(id);
        entity.setDeleted(true);
        repository.save(entity);
        return true;
    }
}
