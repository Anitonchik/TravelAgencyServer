package com.example.TravelAgencyServer.api.tour;

import com.example.TravelAgencyServer.api.Constants;
import com.example.TravelAgencyServer.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.API_URL)
public class TourController {
    static final String URL = "/tour";

    @Autowired
    private TourService service;

    @GetMapping
    public List<TourRs> getAll() {
        return service.getAll();
    }

    @GetMapping("{tourId}")
    public TourRs get(@PathVariable Long tourId){
        return service.getById(tourId);
    }

    @PostMapping
    public TourRs create(@RequestBody TourRq dto) {
        return service.create(dto);
    }

    @PutMapping("{tourId}")
    public TourRs update(@RequestBody TourRq dto, @PathVariable Long tourId) {
        return service.update(dto, tourId);
    }

    @DeleteMapping("{tourId}")
    public boolean delete(@PathVariable Long tourId) {
        return service.delete(tourId);
    }
}
