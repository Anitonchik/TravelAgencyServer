package com.example.TravelAgencyServer.repository;

import com.example.TravelAgencyServer.entity.reservation.VoucherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoucherRepository extends JpaRepository<VoucherEntity, Long> {
    Optional<VoucherEntity> findByReservation_Id(Long reservationId);
}
