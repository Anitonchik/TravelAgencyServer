package com.example.TravelAgencyServer.repository;

import com.example.TravelAgencyServer.entity.reservation.ReservationEntity;
import com.example.TravelAgencyServer.entity.reservation.VoucherInfoEncrypted;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {
    @Query(value = """
    SELECT DISTINCT r.id as reservationId,
           r.reservation_date,
           m.last_name as managerLastName,
           m.first_name as managerFirstName,
           c.first_name as clientFirstName,
           c.last_name as clientLastName,
           c.sur_name as clientSurName,
           (SELECT p.series FROM client_passport_entity p WHERE p.client_id = c.id AND p.is_active = true LIMIT 1) as clientPassportSeries,
           (SELECT p.numbers FROM client_passport_entity p WHERE p.client_id = c.id AND p.is_active = true LIMIT 1) as clientPassportNumbers,
           t.name as tourName,
           t.direction as tourDirection,
           t.price as tourPrice,
           t.date_from as tourDateFrom,
           t.date_to as tourDateTo,
           ft.airline_name as flightToAirlineName,
           ft.location_from as flightToLocationFrom,
           ft.location_to as flightToLocationTo,
           ft.date as flightToDate,
           ft.price as flightToPrice,
           ff.airline_name as flightFromAirlineName,
           ff.location_from as flightFromLocationFrom,
           ff.location_to as flightFromLocationTo,
           ff.date as flightFromDate,
           ff.price as flightFromPrice,
           h.name as hotelName,
           h.location as hotelLocation,
           h.price as hotelPrice,
           r.price as finalPrice,
           r.status,
           r.payment_type,
           r.insurance_type
    FROM reservation_entity r
    LEFT JOIN manager_entity m ON r.manager_id = m.id
    LEFT JOIN client_entity c ON r.client_id = c.id
    LEFT JOIN tour_entity t ON r.tour_id = t.id
    LEFT JOIN flight_entity ft ON r.flight_to_id = ft.id
    LEFT JOIN flight_entity ff ON r.flight_from_id = ff.id
    LEFT JOIN hotel_entity h ON r.hotel_id = h.id
    WHERE r.id = :reservationId
    """, nativeQuery = true)
    Optional<VoucherInfoEncrypted> getVoucherInfo(Long reservationId);
}
