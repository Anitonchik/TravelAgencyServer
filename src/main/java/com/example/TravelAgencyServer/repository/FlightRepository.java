package com.example.TravelAgencyServer.repository;

import com.example.TravelAgencyServer.entity.flight.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<FlightEntity, Long> {
}
