package com.example.TravelAgencyServer.api.CMIPolicy;

import com.example.TravelAgencyServer.api.Constants;
import com.example.TravelAgencyServer.service.CMIPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.API_URL + CMIPolicyController.URL)
public class CMIPolicyController {
    static final String URL = "/CMIPolicy";

    @Autowired
    private CMIPolicyService service;

    @GetMapping
    public List<CMIPolicyRs> getAll() {
        return service.getAll();
    }

    @GetMapping("{CMIPolicyId}")
    public CMIPolicyRs get(@PathVariable Long clientId){
        return service.getById(clientId);
    }

    @PostMapping
    public CMIPolicyRs create(@RequestBody CMIPolicyRq dto) {
        return service.create(dto);
    }

    @PutMapping("{CMIPolicyId}")
    public CMIPolicyRs update(@RequestBody CMIPolicyWithoutClientRq dto, @PathVariable Long CMIPolicyId) {
        return service.update(CMIPolicyId, dto);
    }

    @DeleteMapping("{CMIPolicyId}")
    public boolean delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
