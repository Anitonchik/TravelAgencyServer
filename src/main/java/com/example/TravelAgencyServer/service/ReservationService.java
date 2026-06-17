package com.example.TravelAgencyServer.service;

import com.example.TravelAgencyServer.api.reservation.*;
import com.example.TravelAgencyServer.entity.flight.FlightEntity;
import com.example.TravelAgencyServer.entity.hotel.HotelEntity;
import com.example.TravelAgencyServer.entity.reservation.ReservationEntity;
import com.example.TravelAgencyServer.entity.reservation.Status;
import com.example.TravelAgencyServer.entity.reservation.VoucherEntity;
import com.example.TravelAgencyServer.exceptions.EntityNotExistsException;
import com.example.TravelAgencyServer.repository.ReservationRepository;
import com.example.TravelAgencyServer.repository.VoucherRepository;
import com.example.TravelAgencyServer.service.EmailService.EmailService;
import com.example.TravelAgencyServer.service.EmailService.VoucherService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;

import static com.itextpdf.kernel.xmp.PdfConst.Date;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository repository;

    @Autowired
    private ReservationMapper mapper;

    @Autowired
    private ManagerService managerService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private TourService tourService;

    @Autowired
    private FlightService flightService;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private CipherService cipherService;

    @Autowired
    private VoucherService voucherService;

    @Autowired
    private VoucherRepository voucherRepository;

    @Autowired
    private EmailService emailService;

    @Transactional
    public ReservationEntity findById(Long id) {
        var entity = repository.findById(id);
        if (entity.isPresent()) {
            return entity.get();
        }
        else {
            throw new EntityNotExistsException(id, "Бронирования не существует");
        }
    }

    @Transactional(readOnly = true)
    public ReservationRs getById(Long id) {
        var entity = repository.findById(id);
        if (entity.isPresent()) {
            var tour = tourService.mapTour(entity.get().getTour());
            return mapper.EntityToRs(entity.get(), tour);
        }
        else {
            throw new EntityNotExistsException(id, "Бронирования не существует");
        }
    }

    @Transactional(readOnly = true)
    public Page<ReservationRs> getAll(int pageNumber, int pageSize) {
        return repository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by("reservationDate").descending())).map(entity -> {
            var tour = tourService.mapTour(entity.getTour());
            return mapper.EntityToRs(entity, tour);
        });
    }

    @Transactional
    public Page<ReservationRs> getByDates(LocalDateTime startDate, LocalDateTime endDate, int pageNumber, int pageSize){
        return repository.findByReservationDateBetween(startDate, endDate, PageRequest.of(pageNumber, pageSize, Sort.by("reservationDate").descending()))
                .map(entity -> {
                    var tour = tourService.mapTour(entity.getTour());
                    return mapper.EntityToRs(entity, tour);
                });
    }


    @Transactional
    public Page<ReservationRs> getByClientId(Long clientId, int pageNumber, int pageSize){
        return repository.findByClient_Id(clientId, PageRequest.of(pageNumber, pageSize, Sort.by("reservationDate").descending()))
                .map(entity -> {
                    var tour = tourService.mapTour(entity.getTour());
                    return mapper.EntityToRs(entity, tour);
                });
    }

    @Transactional
    public Page<ReservationRs> getByClientName(String name, int pageNumber, int pageSize){
        return repository.findByClient_FirstNameContainingIgnoreCaseOrClient_LastNameContainingIgnoreCaseOrClient_SurNameContainingIgnoreCase
                (name, name, name, PageRequest.of(pageNumber, pageSize, Sort.by("reservationDate").descending()))
                .map(entity -> {
                    var tour = tourService.mapTour(entity.getTour());
                    return mapper.EntityToRs(entity, tour);
                });
    }

    @Transactional
    public Page<ReservationRs> getByStatus(Status status, int pageNumber, int pageSize){
        return repository.findByStatus(status, PageRequest.of(pageNumber, pageSize, Sort.by("reservationDate").descending()))
                .map(entity -> {
                    var tour = tourService.mapTour(entity.getTour());
                    return mapper.EntityToRs(entity, tour);
                });
    }

    @Transactional
    public ReservationRs startReservation(StartReservationRq dto) {
        var manager = managerService.findById(dto.managerId());
        var client = clientService.findById(dto.clientId());
        var tour = tourService.findById(dto.tourId());
        var tourRs = tourService.mapTour(tour);
        return mapper.EntityToRs(repository.save(mapper.RqToEntity(dto, Status.EXPECTATION, manager, client, tour)), tourRs);
    }

    @Transactional
    public ReservationRs endReservation(ReservationRq dto, Status status) {
        var expEntity = findById(dto.id());
        var manager = managerService.findById(dto.managerId());
        var client = clientService.findById(dto.clientId());
        var tour = tourService.findById(dto.tourId());
        var flightFrom = flightService.updateCountOfSeats(dto.flightFromId());
        var flightTo = flightService.updateCountOfSeats(dto.flightToId());
        var hotel = hotelService.findById(dto.hotelId());

        var price = tour.getPrice() + flightFrom.getPrice() + flightTo.getPrice() + hotel.getPrice();
        var entity = repository.save(mapper.updateEntity(dto, expEntity, price, status,
                manager, client, tour, flightFrom, flightTo, hotel));

        var tourRs = tourService.mapTour(tour);

        return mapper.EntityToRs(entity, tourRs);
    }

    @Transactional
    public ReservationRs cancelReservationInProcess(CancelInProcessReservationRq dto) {
        var expEntity = findById(dto.id());
        var manager = managerService.findById(dto.managerId());
        var client = clientService.findById(dto.clientId());
        var tour = tourService.findById(dto.tourId());

        var entity = repository.save(mapper.updateEntityCancelInProcess(dto, expEntity,
                Status.CANCELED, manager, client, tour));

        var tourRs = tourService.mapTour(tour);

        return mapper.EntityToRs(entity, tourRs);
    }

    /*@Transactional
    public ReservationRs update(ReservationRq dto, Long id) {
        var entity = findById(id);
        var manager = managerService.findById(dto.managerId());
        var client = clientService.findById(dto.clientId());
        var tour = tourService.findById(dto.tourId());
        var flightFrom = flightService.findById(dto.flightFromId());
        var flightTo = flightService.findById(dto.flightToId());
        var hotel = hotelService.findById(dto.hotelId());

        var price = tour.getPrice() + flightFrom.getPrice() + flightTo.getPrice() + hotel.getPrice();
        var updatedEntity = mapper.updateEntity(dto, entity, price, manager, client, tour, flightFrom, flightTo, hotel);
        return mapper.EntityToRs(updatedEntity);
    }*/

    @Transactional
    public byte[] generateVoucher(Long reservationId, boolean indicateTransfer, boolean indicateInsurance) throws Exception {
        var savedVoucher = voucherRepository.findByReservation_Id(reservationId);
        if (savedVoucher.isPresent()) {
            return savedVoucher.get().getVoucher();
        }
        else {
            var voucherInfoEncrypted = repository.getVoucherInfo(reservationId);
            if (voucherInfoEncrypted.isPresent()) {
                String passportNumbers = cipherService.decryptData(voucherInfoEncrypted.get().getClientPassportNumbers());
                String passportSeries = cipherService.decryptData(voucherInfoEncrypted.get().getClientPassportSeries());

                var voucherInfoDecrypted = mapper.EncryptedToDecrypted(voucherInfoEncrypted.get(), passportSeries, passportNumbers);

                var voucher = voucherService.generateReservationPdf(indicateTransfer,
                        indicateInsurance, voucherInfoDecrypted, new Date());
                SaveVoucher(reservationId, voucher);
                return voucher;
            } else {
                throw new EntityNotExistsException(reservationId, "При создании ваучера бронирования не существует");
            }
        }
    }

    public void sendVoucherToEmail(Long reservationId) {
        var newVoucher = voucherRepository.findByReservation_Id(reservationId);
        newVoucher.ifPresent(voucherEntity -> {
            try {
                emailService.sendVoucherToEmail(voucherEntity);
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Transactional
    private void SaveVoucher(Long reservationId, byte[] voucher){
        var reservation = findById(reservationId);
        voucherRepository.save(new VoucherEntity(reservation, voucher));
    }

    @Transactional
    public ReservationsCountRs getReservationsCountByStatus(){
        var counts = repository.getCounts();
        if (counts.isPresent()){
            return counts.get();
        }
        else {
            throw new EntityNotExistsException(0L, "Ошибка получения количества бронирований");
        }
    }
}
