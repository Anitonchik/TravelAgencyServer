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
    public ManagerRs get(@PathVariable Long userId){
        return service.getById(userId);
    }

    @PostMapping
    public ManagerRs create(@RequestBody ManagerRq dto) {
        return service.create(dto);
    }

    @PutMapping("{managerId}")
    public ManagerRs update(@RequestBody ManagerRq dto, @PathVariable Long userId) {
        return service.update(dto, userId);
    }

    @DeleteMapping("{managerId}")
    public boolean delete(@PathVariable Long userId) {
        return service.delete(userId);
    }
}
