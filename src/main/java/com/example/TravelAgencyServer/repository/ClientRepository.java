package com.example.TravelAgencyServer.repository;

import com.example.TravelAgencyServer.api.client.ClientPassportCMIPolicyEntity;
import com.example.TravelAgencyServer.api.client.ClientRs;
import com.example.TravelAgencyServer.entity.client.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
    @Query("SELECT * FROM client_entity c" +
            "JOIN client_passport_entity p ON c.id = p.client_id" +
            "JOIN cmipolicy_entity cmi ON c.id = cmi.client_id" +
            "WHERE c.id = :id AND " +
            "p.is_active = true AND cmi.is_active = true AND c.id_deleted = false")
    Optional<ClientPassportCMIPolicyEntity> getClientPassportPolicy(Long id);

    @Query("SELECT * FROM client_entity c" +
            "JOIN client_passport_entity p ON c.id = p.client_id" +
            "JOIN cmipolicy_entity cmi ON c.id = cmi.client_id" +
            "WHERE p.is_active = true AND cmi.is_active = true AND c.id_deleted = false")
    List<ClientPassportCMIPolicyEntity> getAllClientPassportPolicy();
}
