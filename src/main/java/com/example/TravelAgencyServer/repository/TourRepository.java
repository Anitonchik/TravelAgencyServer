package com.example.TravelAgencyServer.repository;

import com.example.TravelAgencyServer.entity.tour.TourCity;
import com.example.TravelAgencyServer.entity.tour.TourEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface TourRepository extends JpaRepository<TourEntity, Long>, JpaSpecificationExecutor<TourEntity> {

    Page<TourEntity> findByDirectionAndDateFromGreaterThanEqualAndPriceBetween(
            TourCity direction, LocalDateTime dateFrom, Double priceFrom, Double priceTo, Pageable pageable);

    /*@Query("SELECT DISTINCT t FROM TourEntity t " +
            "LEFT JOIN t.hotels h " +
            "WHERE (CAST(:direction AS string) IS NULL OR t.direction = CAST(:direction AS string)) " +
            "AND (CAST(:dateFrom AS LocalDateTime) IS NULL OR t.dateFrom >= :dateFrom) " +
            "AND (CAST(:dateTo AS LocalDateTime) IS NULL OR t.dateTo <= :dateTo) " +
            "AND (CAST(:priceFrom AS Double) IS NULL OR t.price >= :priceFrom) " +
            "AND (CAST(:priceTo AS Double) IS NULL OR t.price <= :priceTo) " +
            "AND (:hotelName IS NULL OR LOWER(h.name) LIKE LOWER(CONCAT('%', :hotelName, '%')))")
    Page<TourEntity> searchTours(
            @Param("direction") String direction,
            @Param("dateFrom") LocalDateTime dateFrom,
            @Param("dateTo") LocalDateTime dateTo,
            @Param("priceFrom") Double priceFrom,
            @Param("priceTo") Double priceTo,
            @Param("hotelName") String hotelName,
            Pageable pageable);

    Page<TourEntity> findByDirectionAndDateFromGreaterThanEqualAndPriceGreaterThanEqualAndPriceLessThanEqual(
            TourCity direction, LocalDateTime date, Double startPrice, Double endPrice, Pageable pageable);*/
}