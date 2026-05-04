package com.example.TravelAgencyServer.repository;

import com.example.TravelAgencyServer.entity.client.ClientPassportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientPassportRepository extends JpaRepository<ClientPassportEntity, Long> {
    List<ClientPassportEntity> findByClient_IdAndIsActiveTrue(Long clientId);
}
