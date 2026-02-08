package com.example.TravelAgencyServer.repository;

import com.example.TravelAgencyServer.entity.tour.TourEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourRepository extends JpaRepository<TourEntity, Long> {
}
