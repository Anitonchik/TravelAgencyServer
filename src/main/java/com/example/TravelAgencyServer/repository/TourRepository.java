package com.example.TravelAgencyServer.repository;

import com.example.TravelAgencyServer.entity.tour.TourEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface TourRepository extends JpaRepository<TourEntity, Long> {
    Page<TourEntity> findByDirectionContainingIgnoreCase(String direction, Pageable pageable);

    Page<TourEntity> findByDateFromAndDateTo(LocalDateTime from, LocalDateTime to, Pageable pageable);

    Page<TourEntity> findByHotels_NameContainingIgnoreCase(String name, Pageable pageable);

    Page<TourEntity> findByPriceBetween(Double start, Double end, Pageable pageable);
}
