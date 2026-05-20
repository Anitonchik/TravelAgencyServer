package com.example.TravelAgencyServer.api.tour;

import com.example.TravelAgencyServer.api.Constants;
import com.example.TravelAgencyServer.service.TourService;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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

    @GetMapping("/search/byDirection")
    public Page<TourRs> getByDirection(@RequestParam String direction,
                                       @RequestParam(defaultValue = "0") @Min(0) int pageNumber,
                                       @RequestParam(defaultValue = "15") @Min(1) int pageSize) {
        return service.getByDirection(direction, pageNumber, pageSize);
    }

    @GetMapping("/search/byDates")
    public Page<TourRs> getByDates(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                       LocalDate dateFrom,
                                  @RequestParam LocalDate dateTo,
                                  @RequestParam(defaultValue = "0") @Min(0) int pageNumber,
                                  @RequestParam(defaultValue = "15") @Min(1) int pageSize) {
        LocalDateTime start = dateFrom.atStartOfDay();
        LocalDateTime end = dateTo.atTime(23, 59, 59);
        return service.getByDates(start, end, pageNumber, pageSize);
    }

    @GetMapping("/search/byDate")
    public Page<TourRs> getByDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                      LocalDate date,
                                   @RequestParam(defaultValue = "0") @Min(0) int pageNumber,
                                   @RequestParam(defaultValue = "15") @Min(1) int pageSize) {
        LocalDateTime start = date.atStartOfDay();
        LocalDateTime end = date.atTime(23, 59, 59);
        return service.getByDates(start, end, pageNumber, pageSize);
    }

    @GetMapping("/search/byHotel")
    public Page<TourRs> getByHotel(@RequestParam String hotelName,
                                   @RequestParam(defaultValue = "0") @Min(0) int pageNumber,
                                   @RequestParam(defaultValue = "15") @Min(1) int pageSize) {
        return service.getByHotel(hotelName, pageNumber, pageSize);
    }

    @GetMapping("/search/byPrice")
    public Page<TourRs> getByPrice(@RequestParam Double priceStart,
                                   @RequestParam Double priceEnd,
                                   @RequestParam(defaultValue = "0") @Min(0) int pageNumber,
                                   @RequestParam(defaultValue = "15") @Min(1) int pageSize) {
        return service.getByPrice(priceStart, priceEnd, pageNumber, pageSize);
    }

    @GetMapping("{tourId}")
    public TourRs get(@PathVariable Long tourId){
        return service.getById(tourId);
    }
}
