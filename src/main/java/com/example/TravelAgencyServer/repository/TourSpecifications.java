package com.example.TravelAgencyServer.repository;

import com.example.TravelAgencyServer.entity.hotel.HotelEntity;
import com.example.TravelAgencyServer.entity.tour.TourEntity;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;

import java.time.LocalDateTime;

public class TourSpecifications {
    public static Specification<TourEntity> hasDirection(String direction) {
        return (root, query, cb) -> direction == null ?
                cb.conjunction() :
                cb.equal(root.get("direction"), direction);
    }

    public static Specification<TourEntity> hasDateRange(LocalDateTime dateFrom, LocalDateTime dateTo) {
        return (root, query, cb) -> {
            if (dateFrom == null && dateTo == null) {
                return cb.conjunction();
            }
            if (dateFrom != null && dateTo != null) {
                return cb.and(
                        cb.greaterThanOrEqualTo(root.get("dateFrom"), dateFrom),
                        cb.lessThanOrEqualTo(root.get("dateTo"), dateTo)
                );
            }
            if (dateFrom != null) {
                return cb.greaterThanOrEqualTo(root.get("dateFrom"), dateFrom);
            }
            return cb.lessThanOrEqualTo(root.get("dateTo"), dateTo);
        };
    }

    public static Specification<TourEntity> hasPriceRange(Double priceFrom, Double priceTo) {
        return (root, query, cb) -> {
            if (priceFrom == null && priceTo == null) {
                return cb.conjunction();
            }
            if (priceFrom != null && priceTo != null) {
                return cb.and(
                        cb.greaterThanOrEqualTo(root.get("price"), priceFrom),
                        cb.lessThanOrEqualTo(root.get("price"), priceTo)
                );
            }
            if (priceFrom != null) {
                return cb.greaterThanOrEqualTo(root.get("price"), priceFrom);
            }
            return cb.lessThanOrEqualTo(root.get("price"), priceTo);
        };
    }

    public static Specification<TourEntity> hasHotelName(String hotelName) {
        return (root, query, cb) -> {
            if (hotelName == null || hotelName.isBlank()) {
                return cb.conjunction();
            }
            Join<TourEntity, HotelEntity> hotelJoin = root.join("hotels", JoinType.INNER);
            return cb.like(cb.lower(hotelJoin.get("name")), "%" + hotelName.toLowerCase() + "%");
        };
    }

    public static Specification<TourEntity> searchTours(String direction, LocalDateTime dateFrom, LocalDateTime dateTo,
                                                        Double priceFrom, Double priceTo, String hotelName) {
        return Specification
                .where(hasDirection(direction))
                .and(hasDateRange(dateFrom, dateTo))
                .and(hasPriceRange(priceFrom, priceTo))
                .and(hasHotelName(hotelName));
    }
}
