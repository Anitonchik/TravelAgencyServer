package com.example.TravelAgencyServer.repository;

import com.example.TravelAgencyServer.entity.client.ClientPassportCMIPolicy;
import com.example.TravelAgencyServer.entity.client.ClientEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
    @Query(value = """
    SELECT DISTINCT c.id,
    c.first_name,
    c.last_name,
    c.sur_name,
    CAST(c.birth_date AS timestamp) as birth_date,
    c.snils,
    c.email,
    c.phone,
    c.preference_description,
    p.id as passportId,
    p.series as passportSeries,
    p.numbers as passportNumbers,
    p.image as passportImage,
    cmi.id as policyId,
    cmi.CMIPolicy as CMIPolicy,
    cmi.image as policyImage
    FROM client_entity c
    JOIN client_passport_entity p ON c.id = p.client_id
    JOIN cmipolicy_entity cmi ON c.id = cmi.client_id
    WHERE c.id = :id
      AND p.is_active = true
      AND cmi.is_active = true
      AND c.is_deleted = false
    LIMIT 1
""", nativeQuery = true)
    Optional<ClientPassportCMIPolicy> getClientPassportPolicy(Long id);

    @Query(value = """
    SELECT DISTINCT c.id,
    c.first_name,
    c.last_name,
    c.sur_name,
    CAST(c.birth_date AS timestamp) as birth_date,
    c.snils,
    c.email,
    c.phone,
    c.preference_description,
    p.id as passportId,
    p.series as passportSeries,
    p.numbers as passportNumbers,
    p.image as passportImage,
    cmi.id as policyId,
    cmi.CMIPolicy as CMIPolicy,
    cmi.image as policyImage
    FROM client_entity c
    JOIN client_passport_entity p ON c.id = p.client_id
    JOIN cmipolicy_entity cmi ON c.id = cmi.client_id
    WHERE p.is_active = true
      AND cmi.is_active = true
      AND c.is_deleted = false
""", nativeQuery = true)
    Page<ClientPassportCMIPolicy> getAllClientPassportPolicy(Pageable pageable);


    @Query(value = """
    SELECT DISTINCT c.id,
    c.first_name,
    c.last_name,
    c.sur_name,
    CAST(c.birth_date AS timestamp) as birth_date,
    c.snils,
    c.email,
    c.phone,
    c.preference_description,
    p.id as passportId,
    p.series as passportSeries,
    p.numbers as passportNumbers,
    p.image as passportImage,
    cmi.id as policyId,
    cmi.CMIPolicy as CMIPolicy,
    cmi.image as policyImage
    FROM client_entity c
    JOIN client_passport_entity p ON c.id = p.client_id
    JOIN cmipolicy_entity cmi ON c.id = cmi.client_id
    WHERE p.is_active = true
      AND cmi.is_active = true
      AND c.is_deleted = false
      AND LOWER(CONCAT(c.last_name, c.first_name, c.sur_name)) LIKE LOWER(CONCAT('%', :name, '%'))
""", nativeQuery = true)
    Page<ClientPassportCMIPolicy> getAllClientPassportPolicyByName(String name, Pageable pageable);
}
