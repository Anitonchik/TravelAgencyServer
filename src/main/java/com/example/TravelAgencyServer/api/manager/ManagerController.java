package com.example.TravelAgencyServer.api.manager;

import com.example.TravelAgencyServer.api.Constants;
import com.example.TravelAgencyServer.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.API_URL + ManagerController.URL)
public class ManagerController {
    static final String URL = "/manager";

    @Autowired
    private ManagerService service;

    @GetMapping
    public List<ManagerRs> getAll() {
        return service.getAll();
    }

    @GetMapping("{managerId}")
    public ManagerRs get(@PathVariable Long managerId){
        return service.getById(managerId);
    }

    @PostMapping
    public ManagerRs create(@RequestBody ManagerRq dto) {
        return service.create(dto);
    }

    @PutMapping("{managerId}")
    public ManagerRs update(@RequestBody ManagerRq dto, @PathVariable Long managerId) {
        return service.update(dto, managerId);
    }

    @DeleteMapping("{managerId}")
    public boolean delete(@PathVariable Long managerId) {
        return service.delete(managerId);
    }
}
