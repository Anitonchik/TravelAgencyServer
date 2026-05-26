package com.example.TravelAgencyServer.repository;

import com.example.TravelAgencyServer.entity.client.ClientPassportCMIPolicy;
import com.example.TravelAgencyServer.entity.client.ClientEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    @Query("""
    SELECT NEW com.example.TravelAgencyServer.entity.client.ClientPassportCMIPolicy(
        c.id,
        c.firstName,
        c.lastName,
        c.surName,
        c.birthDate,
        c.snils,
        c.email,
        c.phone,
        c.preferenceCity,
        c.preferenceDateFrom,
        c.preferencePriceFrom,
        c.preferencePriceTo,
        p.id,
        p.series,
        p.numbers,
        p.image,
        cmi.id,
        cmi.CMIPolicy,
        cmi.image
    )
    FROM ClientEntity c
    JOIN c.passports p
    JOIN c.CMIPolicies cmi
    WHERE c.id = :id
      AND p.isActive = true
      AND cmi.isActive = true
      AND c.isDeleted = false
    """)
    Optional<ClientPassportCMIPolicy> getClientPassportPolicy(@Param("id") Long id);

    @Query("""
    SELECT NEW com.example.TravelAgencyServer.entity.client.ClientPassportCMIPolicy(
        c.id,
        c.firstName,
        c.lastName,
        c.surName,
        c.birthDate,
        c.snils,
        c.email,
        c.phone,
        c.preferenceCity,
        c.preferenceDateFrom,
        c.preferencePriceFrom,
        c.preferencePriceTo,
        p.id,
        p.series,
        p.numbers,
        p.image,
        cmi.id,
        cmi.CMIPolicy,
        cmi.image
    )
    FROM ClientEntity c
    JOIN c.passports p
    JOIN c.CMIPolicies cmi
    WHERE p.isActive = true
      AND cmi.isActive = true
      AND c.isDeleted = false
    """)
    Page<ClientPassportCMIPolicy> getAllClientPassportPolicy(Pageable pageable);

    @Query("""
    SELECT NEW com.example.TravelAgencyServer.entity.client.ClientPassportCMIPolicy(
        c.id,
        c.firstName,
        c.lastName,
        c.surName,
        c.birthDate,
        c.snils,
        c.email,
        c.phone,
        c.preferenceCity,
        c.preferenceDateFrom,
        c.preferencePriceFrom,
        c.preferencePriceTo,
        p.id,
        p.series,
        p.numbers,
        p.image,
        cmi.id,
        cmi.CMIPolicy,
        cmi.image
    )
    FROM ClientEntity c
    JOIN c.passports p
    JOIN c.CMIPolicies cmi
    WHERE p.isActive = true
      AND cmi.isActive = true
      AND c.isDeleted = false
      AND LOWER(CONCAT(c.lastName, c.firstName, c.surName)) LIKE LOWER(CONCAT('%', :name, '%'))
    """)
    Page<ClientPassportCMIPolicy> getAllClientPassportPolicyByName(@Param("name") String name, Pageable pageable);
}