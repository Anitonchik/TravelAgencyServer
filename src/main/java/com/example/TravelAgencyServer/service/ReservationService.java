package com.example.TravelAgencyServer.service;

import com.example.TravelAgencyServer.api.reservation.ReservationMapper;
import com.example.TravelAgencyServer.api.reservation.ReservationRq;
import com.example.TravelAgencyServer.api.reservation.ReservationRs;
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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

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
            return mapper.EntityToRs(entity.get());
        }
        else {
            throw new EntityNotExistsException(id, "Бронирования не существует");
        }
    }

    @Transactional(readOnly = true)
    public List<ReservationRs> getAll() {
        return mapper.ListEntitiesToListRq(repository.findAll());
    }

    @Transactional
    public ReservationRs create(ReservationRq dto) {
        var manager = managerService.findById(dto.managerId());
        var client = clientService.findById(dto.clientId());
        var tour = tourService.findById(dto.tourId());
        FlightEntity flightFrom = null;
        FlightEntity flightTo = null;
        HotelEntity hotel = null;

        if (dto.flightFromId() != null) {
            flightFrom = flightService.updateCountOfSeats(dto.flightFromId());
        }
        if (dto.flightToId() != null) {
            flightTo = flightService.updateCountOfSeats(dto.flightToId());
        }
        if (dto.hotelId() != null) {
            hotel = hotelService.findById(dto.hotelId());
        }

        ReservationEntity entity;
        if (dto.flightFromId() != null && dto.flightToId() != null && dto.hotelId() != null) {
            var price = tour.getPrice() + flightFrom.getPrice() + flightTo.getPrice() + hotel.getPrice();
            entity = repository.save(mapper.RqToEntity(dto, price, manager, client, tour, flightFrom, flightTo, hotel));
        }
        else {
            entity = repository.save(mapper.RqToEntity(dto, Status.EXPECTATION, manager, client, tour));
        }
        return mapper.EntityToRs(entity);
    }

    @Transactional
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
    }

    @Transactional
    public boolean delete(Long id){
        repository.findById(id).ifPresent(clientEntity -> repository.delete(clientEntity));
        return repository.existsById(id);
    }

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
                        indicateInsurance, voucherInfoDecrypted, LocalDateTime.now());
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
}
