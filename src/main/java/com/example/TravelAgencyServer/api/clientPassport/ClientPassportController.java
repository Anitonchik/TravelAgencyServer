package com.example.TravelAgencyServer.api.clientPassport;

import com.example.TravelAgencyServer.api.Constants;
import com.example.TravelAgencyServer.service.ClientPassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.API_URL + ClientPassportController.URL)
public class ClientPassportController {
    static final String URL = "/clientPassport";

    @Autowired
    private ClientPassportService service;

    @GetMapping
    public List<ClientPassportRs> getAll() {
        return service.getAll();
    }

    @GetMapping("{clientPassportId}")
    public ClientPassportRs get(@PathVariable Long clientId){
        return service.getById(clientId);
    }

    @PostMapping
    public ClientPassportRs create(@RequestBody ClientPassportRq dto) {
        return service.create(dto);
    }

    @PutMapping("{clientPassportId}")
    public ClientPassportRs update(@RequestBody ClientPassportWithoutClientRq dto, @PathVariable Long clientPassportId) {
        return service.update(clientPassportId, dto);
    }

    @DeleteMapping("{clientPassportId}")
    public boolean delete(@PathVariable Long id) {
        return service.delete(id);
    }

}
