package com.example.TravelAgencyServer.api.tour;

import com.example.TravelAgencyServer.api.Constants;
import com.example.TravelAgencyServer.service.TourService;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping(Constants.API_URL + TourController.URL)
public class TourController {
    static final String URL = "/tour";

    @Autowired
    private TourService service;

    @GetMapping
    public Page<TourRs> getAll(@RequestParam(defaultValue = "0") @Min(0) int pageNumber,
                               @RequestParam(defaultValue = "15") @Min(1) int pageSize) {
        return service.getAll(pageNumber, pageSize);
    }

    @GetMapping("/search/byClientPreferences")
    public Page<TourRs> getByClientPreferences(@RequestParam Long clientId,
                                               @RequestParam(defaultValue = "0") @Min(0) int pageNumber,
                                               @RequestParam(defaultValue = "15") @Min(1) int pageSize) {
        return service.getByClientPreferences(clientId, pageNumber, pageSize);
    }

    @GetMapping("/search")
    public Page<TourRs> searchTours(
            @RequestParam(required = false) String direction,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateFrom,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateTo,
            @RequestParam(required = false) Double priceFrom,
            @RequestParam(required = false) Double priceTo,
            @RequestParam(required = false) String hotelName,
            @RequestParam(defaultValue = "0") @Min(0) int pageNumber,
            @RequestParam(defaultValue = "15") @Min(1) int pageSize) {
        LocalDateTime start = dateFrom != null ? dateFrom.atStartOfDay() : null;
        LocalDateTime end = dateTo != null ? dateTo.atTime(23, 59, 59) : null;
        return service.searchTours(direction, start, end, priceFrom, priceTo, hotelName, pageNumber, pageSize);
    }

    @GetMapping("{tourId}")
    public TourRs get(@PathVariable Long tourId) {
        return service.getById(tourId);
    }
}