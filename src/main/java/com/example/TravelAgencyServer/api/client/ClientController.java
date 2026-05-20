package com.example.TravelAgencyServer.api.client;

import com.example.TravelAgencyServer.api.Constants;
import com.example.TravelAgencyServer.service.ClientService;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.API_URL + ClientController.URL)
public class ClientController {
    public static final String URL = "/client";

    @Autowired
    private ClientService service;

    @GetMapping
    public Page<ClientRs> getAll(@RequestParam(defaultValue = "0") @Min(0) int pageNumber,
                                 @RequestParam(defaultValue = "15") @Min(1) int pageSize) {
        return service.getAll(pageNumber, pageSize);
    }

    @GetMapping("/byName")
    public Page<ClientRs> getByName(@RequestParam String name,
                                    @RequestParam(defaultValue = "0") @Min(0) int pageNumber,
                                    @RequestParam(defaultValue = "15") @Min(1) int pageSize) {
        return service.getByName(name, pageNumber, pageSize);
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
