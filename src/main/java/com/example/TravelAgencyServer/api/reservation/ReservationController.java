package com.example.TravelAgencyServer.api.reservation;

import com.example.TravelAgencyServer.api.Constants;
import com.example.TravelAgencyServer.entity.reservation.Status;
import com.example.TravelAgencyServer.service.ReservationService;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(Constants.API_URL + ReservationController.URL)
public class ReservationController {
    public static final String URL = "/reservation";

    @Autowired
    private ReservationService service;

    @GetMapping
    public Page<ReservationRs> getAll(
            @RequestParam(defaultValue = "0") @Min(0) int pageNumber,
            @RequestParam(defaultValue = "15") @Min(1) int pageSize) {
        return service.getAll(pageNumber, pageSize);
    }

    @GetMapping("/search/byDate")
    public Page<ReservationRs> getByDate(@RequestParam
                                             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                             LocalDate date,
                                         @RequestParam(defaultValue = "0") @Min(0) int pageNumber,
                                         @RequestParam(defaultValue = "15") @Min(1) int pageSize){
        LocalDateTime start = date.atStartOfDay();
        LocalDateTime end = date.atTime(23, 59, 59);
        return service.getByDates(start, end, pageNumber, pageSize);
    }

    @GetMapping("/search/byDates")
    public Page<ReservationRs> getByDates(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                              LocalDate startDate,
                                          @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                          LocalDate endDate,
                                          @RequestParam(defaultValue = "0") @Min(0) int pageNumber,
                                          @RequestParam(defaultValue = "15") @Min(1) int pageSize){
        LocalDateTime start = startDate.atStartOfDay();
        LocalDateTime end = endDate.atTime(23, 59, 59);
        return service.getByDates(start, end, pageNumber, pageSize);
    }

    @GetMapping("/search/byClient")
    public Page<ReservationRs> getByClientId(@RequestParam Long clientId,
                                             @RequestParam(defaultValue = "0") @Min(0) int pageNumber,
                                             @RequestParam(defaultValue = "15") @Min(1) int pageSize){
        return service.getByClientId(clientId, pageNumber, pageSize);
    }

    @GetMapping("/search/byClientName")
    public Page<ReservationRs> getByClientName(@RequestParam String clientName,
                                               @RequestParam(defaultValue = "0") @Min(0) int pageNumber,
                                               @RequestParam(defaultValue = "15") @Min(1) int pageSize){
        return service.getByClientName(clientName, pageNumber, pageSize);
    }

    @GetMapping("/search/byStatus")
    public Page<ReservationRs> getByStatus(@RequestParam Status status,
                                           @RequestParam(defaultValue = "0") @Min(0) int pageNumber,
                                           @RequestParam(defaultValue = "15") @Min(1) int pageSize){
        return service.getByStatus(status, pageNumber, pageSize);
    }

    @GetMapping("{reservationId}")
    public ReservationRs get(@PathVariable Long reservationId){
        return service.getById(reservationId);
    }

    @PostMapping("/start")
    public ReservationRs startReservation(@RequestBody StartReservationRq dto){
        return service.startReservation(dto);
    }

    @PutMapping("/end")
    public ReservationRs endReservation(@RequestBody ReservationRq dto) {
        return service.endReservation(dto, Status.CONFIRMED);
    }

    @PutMapping("/cancelInProcess")
    public ReservationRs cancelReservationInProcess(@RequestBody CancelInProcessReservationRq dto) {
        return service.cancelReservationInProcess(dto);
    }

    @PutMapping("/cancel")
    public ReservationRs cancelReservation(@RequestBody ReservationRq dto) {
        return service.endReservation(dto, Status.CANCELED);
    }

    @PostMapping("/voucher")
    public ResponseEntity<byte[]> getVoucher(@RequestBody VoucherRq dto) throws Exception {
        return ResponseEntity.ok()
                .header("Content-Type", "application/pdf")
                .header("Content-Disposition", "attachment; filename=voucher.pdf")
                .body(service.generateVoucher(dto.reservationId(), dto.indicateTransfer(), dto.indicateInsurance()));
    }

    @GetMapping("/voucher/send/{reservationId}")
    public @ResponseBody ResponseEntity sendSimpleEmail(@PathVariable Long reservationId) {
        try {
            service.sendVoucherToEmail(reservationId);
        } catch (MailException mailException) {
            return new ResponseEntity<>("Unable to send email", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Please check your inbox", HttpStatus.OK);
    }

    @GetMapping("/counts")
    public ReservationsCountRs getCounts(){
        return service.getReservationsCountByStatus();
    }
}
