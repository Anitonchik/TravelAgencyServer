package com.example.TravelAgencyServer.api.hotel;

import com.example.TravelAgencyServer.api.Constants;
import com.example.TravelAgencyServer.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.API_URL + HotelController.URL)
public class HotelController {
    static final String URL = "/hotel";

    @Autowired
    private HotelService service;

    @GetMapping
    public List<HotelRs> getAll() {
        return service.getAll();
    }

    @GetMapping("{hotelId}")
    public HotelRs get(@PathVariable Long hotelId){
        return service.getById(hotelId);
    }

    @PostMapping
    public HotelRs create(@RequestBody HotelRq dto) {
        return service.create(dto);
    }

    @PutMapping("{hotelId}")
    public HotelRs update(@RequestBody HotelRq dto, @PathVariable Long hotelId) {
        return service.update(dto, hotelId);
    }

    @DeleteMapping("{hotelId}")
    public boolean delete(@PathVariable Long hotelId) {
        return service.delete(hotelId);
    }
}
