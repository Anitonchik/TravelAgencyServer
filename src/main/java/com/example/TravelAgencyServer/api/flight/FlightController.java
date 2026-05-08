package com.example.TravelAgencyServer.api.flight;

import com.example.TravelAgencyServer.api.Constants;
import com.example.TravelAgencyServer.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.API_URL + FlightController.URL)
public class FlightController {
    public static final String URL = "/flight";

    @Autowired
    private FlightService service;

    @GetMapping
    public List<FlightRs> getAll() {
        return service.getAll();
    }

    @GetMapping("{flightId}")
    public FlightRs get(@PathVariable Long flightId){
        return service.getById(flightId);
    }

    @PostMapping
    public FlightRs create(@RequestBody FlightRq dto) {
        return service.create(dto);
    }

    @PutMapping("{flightId}")
    public FlightRs update(@RequestBody FlightRq dto, @PathVariable Long flightId) {
        return service.update(dto, flightId);
    }

    @DeleteMapping("{flightId}")
    public boolean delete(@PathVariable Long flightId) {
        return service.delete(flightId);
    }
}
