package com.example.TravelAgencyServer.service;

import com.example.TravelAgencyServer.api.manager.ManagerMapper;
import com.example.TravelAgencyServer.api.manager.ManagerRq;
import com.example.TravelAgencyServer.api.manager.ManagerRs;
import com.example.TravelAgencyServer.entity.manager.ManagerEntity;
import com.example.TravelAgencyServer.exceptions.EntityNotExistsException;
import com.example.TravelAgencyServer.exceptions.InvalidLoginException;
import com.example.TravelAgencyServer.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ManagerService {
    @Autowired
    private ManagerRepository repository;

    @Autowired
    private ManagerMapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public ManagerEntity findById(Long id) {
        var entity = repository.findById(id);
        if (entity.isPresent()) {
            return entity.get();
        }
        else {
            throw new EntityNotExistsException(id, "Менеджера не существует");
        }
    }

    @Transactional(readOnly = true)
    public ManagerRs getById(Long id) {
        var entity = repository.findById(id);
        if (entity.isPresent()) {
            return mapper.EntityToRs(entity.get());
        }
        else {
            throw new EntityNotExistsException(id, "Менеджера не существует");
        }
    }

    public ManagerEntity findByLogin(String login){
        var manager = repository.findByLogin(login);
        if (manager.isPresent()){
            return manager.get();
        }
        else {
            throw new InvalidLoginException(login);
        }
    }

    @Transactional(readOnly = true)
    public List<ManagerRs> getAll() {
        return mapper.ListEntitiesToListRq(repository.findAll());
    }

    @Transactional
    public ManagerRs create(ManagerRq dto) {
        var entity = repository.save(mapper.RqToEntity(dto, passwordEncoder));
        return mapper.EntityToRs(entity);
    }

    @Transactional
    public ManagerRs update(ManagerRq dto, Long id) {
        var entity = findById(id);
        var updatedEntity = mapper.updateEntity(dto, entity, passwordEncoder);
        return mapper.EntityToRs(updatedEntity);
    }

    @Transactional
    public boolean delete(Long id){
        repository.findById(id).ifPresent(clientEntity -> repository.delete(clientEntity));
        return repository.existsById(id);
    }

    public ManagerRs EntityToRs(ManagerEntity entity) {
        return mapper.EntityToRs(entity);
    }
}
