package com.example.TravelAgencyServer.api.reservation;

import com.example.TravelAgencyServer.api.Constants;
import com.example.TravelAgencyServer.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.API_URL + ReservationController.URL)
public class ReservationController {
    public static final String URL = "/reservation";

    @Autowired
    private ReservationService service;

    @GetMapping
    public List<ReservationRs> getAll() {
        return service.getAll();
    }

    @GetMapping("{reservationId}")
    public ReservationRs get(@PathVariable Long reservationId){
        return service.getById(reservationId);
    }

    @PostMapping
    public ReservationRs create(@RequestBody ReservationRq dto) {
        return service.create(dto);
    }

    @PutMapping("{reservationId}")
    public ReservationRs update(@RequestBody ReservationRq dto, @PathVariable Long reservationId) {
        return service.update(dto, reservationId);
    }

    @DeleteMapping("{reservationId}")
    public boolean delete(@PathVariable Long reservationId) {
        return service.delete(reservationId);
    }
}
