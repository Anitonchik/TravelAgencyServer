package com.example.TravelAgencyServer.service;

import com.example.TravelAgencyServer.api.CMIPolicy.CMIPolicyRq;
import com.example.TravelAgencyServer.api.CMIPolicy.CMIPolicyRs;
import com.example.TravelAgencyServer.api.client.ClientMapper;
import com.example.TravelAgencyServer.entity.client.CMIPolicyEntity;
import com.example.TravelAgencyServer.entity.client.ClientPassportCMIPolicy;
import com.example.TravelAgencyServer.api.client.ClientRq;
import com.example.TravelAgencyServer.api.client.ClientRs;
import com.example.TravelAgencyServer.api.clientPassport.ClientPassportRq;
import com.example.TravelAgencyServer.api.clientPassport.ClientPassportRs;
import com.example.TravelAgencyServer.entity.client.ClientEntity;
import com.example.TravelAgencyServer.entity.client.ClientPassportEntity;
import com.example.TravelAgencyServer.exceptions.EntityNotExistsException;
import com.example.TravelAgencyServer.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;

    @Autowired
    private ClientMapper mapper;

    @Autowired
    private CipherService cipherService;

    @Autowired
    private ClientPassportService clientPassportService;

    @Autowired
    private CMIPolicyService cmiPolicyService;


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
            return decryptData(entity.get());
        }
        else {
            throw new EntityNotExistsException(id, "Клиент не существует");
        }
    }

    @Transactional(readOnly = true)
    public Page<ClientRs> getAll(int pageNumber, int pageSize) {
        return repository.getAllClientPassportPolicy(PageRequest.of(pageNumber, pageSize))
                .map(this::decryptData);
    }

    @Transactional(readOnly = true)
    public Page<ClientRs> getByName(String name, int pageNumber, int pageSize) {
        return repository.getAllClientPassportPolicyByName(name, PageRequest.of(pageNumber, pageSize))
                .map(this::decryptData);
    }

    @Transactional
    public ClientRs create(ClientRq dto) {
        var entity = mapper.ClientRqToClientEntity(dto);
        entity.setSnils(cipherService.encryptData(dto.snils()));
        repository.save(entity);

        var passportRq = new ClientPassportRq(entity.getId(), dto.passportSeries(), dto.passportNumbers(), dto.policyImage());
        clientPassportService.create(passportRq);

        var cmiPolicyRq = new CMIPolicyRq(entity.getId(), dto.policy(), dto.policyImage());
        cmiPolicyService.create(cmiPolicyRq);

        var newEntity = repository.getClientPassportPolicy(entity.getId());
        if (newEntity.isPresent()) {
            return decryptData(newEntity.get());
        }
        throw new EntityNotExistsException(entity.getId(), "Клиента не существует");
    }

    @Transactional
    public ClientRs update(ClientRq dto, Long id) {
        var entity = findById(id);
        entity = mapper.UpdateClientRqToClientEntity(dto, entity);

        var passport = clientPassportService.getByClientId(id);
        var dcrPassport = decryptPassport(passport);
        if (!Objects.equals(dcrPassport.getSeries(), dto.passportSeries())
                || !Objects.equals(dcrPassport.getNumbers(), dto.passportNumbers())){

            var passportRq = new ClientPassportRq(entity.getId(), dto.passportSeries(),
                    dto.passportNumbers(), dto.policyImage());
            clientPassportService.update(entity.getId(), passportRq);
        }


        var cmiPolicy = cmiPolicyService.getByClient(id);
        var dcrCmiPolicy = decryptPolicy(cmiPolicy);
        if (!Objects.equals(dcrCmiPolicy.CMIPolicy(), dto.policy())) {
            var cmiPolicyRq = new CMIPolicyRq(entity.getId(), dto.policy(), dto.policyImage());
            cmiPolicyService.update(entity.getId(), cmiPolicyRq);
        }

        var newEntity = repository.getClientPassportPolicy(entity.getId());
        if (newEntity.isPresent()) {
            return decryptData(newEntity.get());
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

    public ClientRs entityToRs(ClientEntity entity) {
        return mapper.ClientEntityToClientRs(entity);
    }

    private ClientRs decryptData(ClientPassportCMIPolicy entity) {
        var dto = mapper.ClientPassportCMIPolicyEntityToClientRs(entity);
        dto.setSnils(cipherService.decryptData(entity.getSnils()));

        var passport = new ClientPassportRs(entity.getPassportId(),
                cipherService.decryptData(entity.getPassportSeries()),
                cipherService.decryptData(entity.getPassportNumbers()),
                cipherService.decryptData(entity.getPassportImage()));
        dto.setPassport(passport);

        var policy = new CMIPolicyRs(entity.getPolicyId(),
                cipherService.decryptData(entity.getCMIPolicy()),
                cipherService.decryptData(entity.getPolicyImage()));
        dto.setPolicy(policy);

        return dto;
    }

    private ClientPassportRs decryptPassport(ClientPassportEntity entity) {
        return new ClientPassportRs(entity.getId(),
                cipherService.decryptData(entity.getSeries()),
                cipherService.decryptData(entity.getNumbers()),
                cipherService.decryptData(entity.getImage()));
    }

    private CMIPolicyRs decryptPolicy(CMIPolicyEntity entity) {
        return new CMIPolicyRs(entity.getId(),
                cipherService.decryptData(entity.getCMIPolicy()),
                cipherService.decryptData(entity.getImage()));
    }
}
