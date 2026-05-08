package com.example.TravelAgencyServer.repository;

import com.example.TravelAgencyServer.entity.reservation.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {
}
