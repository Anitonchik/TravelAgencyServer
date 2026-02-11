package com.example.TravelAgencyServer.api.client;

import com.example.TravelAgencyServer.api.Constants;
import com.example.TravelAgencyServer.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.API_URL + ClientController.URL)
public class ClientController {
    public static final String URL = "/client";

    @Autowired
    private ClientService service;

    @GetMapping
    public List<ClientRs> getAll() {
        return service.getAll();
    }

    @GetMapping("{clientId}")
    public ClientRs get(@PathVariable Long clientId){
        return service.getById(clientId);
    }

    @PostMapping
    public ClientRs create(@RequestBody ClientRq dto) {
        return service.create(dto);
    }

    @PutMapping("{clientId}")
    public ClientRs update(@RequestBody ClientRq dto, @PathVariable Long clientId) {
        return service.update(dto, clientId);
    }

    @DeleteMapping("{clientId}")
    public boolean delete(@PathVariable Long clientId) {
        return service.delete(clientId);
    }
}
