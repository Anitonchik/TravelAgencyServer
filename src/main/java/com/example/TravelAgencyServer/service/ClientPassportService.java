package com.example.TravelAgencyServer.service;

import com.example.TravelAgencyServer.api.clientPassport.ClientPassportRq;
import com.example.TravelAgencyServer.entity.client.ClientPassportEntity;
import com.example.TravelAgencyServer.exceptions.EntityNotExistsException;
import com.example.TravelAgencyServer.repository.ClientPassportRepository;
import com.example.TravelAgencyServer.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientPassportService {
    @Autowired
    private ClientPassportRepository repository;


    /*@Autowired
    private ClientMappers clientMappers;*/
    
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CipherService cipherService;

    public ClientPassportEntity findById(Long id) {
        var entity =  repository.findById(id);
        if (entity.isPresent()) {
            return entity.get();
        }
        else throw new EntityNotExistsException(id, "Пасспорт не существует");
    }

    /*public List<ClientPassportRs> getAll() {
        return mapper.ListEntityToListRs(repository.findAll(), clientMappers, cipherService);
    }

    public ClientPassportRs getById(Long id) {
        return mapper.EntityToRs(findById(id), clientMappers, cipherService);
    }*/
    
    public ClientPassportEntity create(ClientPassportRq dto) {
        var client = clientRepository.findById(dto.clientId());
        if (client.isPresent()) {
            var entity = new ClientPassportEntity(
                    client.get(),
                    cipherService.encryptData(dto.series()),
                    cipherService.encryptData(dto.numbers()),
                    cipherService.encryptData(dto.image())
            );
            return repository.save(entity);
        }
        throw new EntityNotExistsException(dto.clientId(), "При создании пасспорта клиент под id е существует");
    }
    
    public ClientPassportEntity update(Long clientId, ClientPassportRq dto){
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

    /*public void createNew(ClientPassportRq dto){
        ClientPassportEntity entity = new ClientPassportEntity(dto.clientId(), dto.series(), dto.numbers(), dto.image())
    }*/
}
