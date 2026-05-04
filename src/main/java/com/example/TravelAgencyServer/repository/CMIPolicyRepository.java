package com.example.TravelAgencyServer.repository;

import com.example.TravelAgencyServer.entity.client.CMIPolicyEntity;
import com.example.TravelAgencyServer.entity.client.ClientPassportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CMIPolicyRepository extends JpaRepository<CMIPolicyEntity, Long> {
    List<CMIPolicyEntity> findByClient_IdAndIsActiveTrue(Long clientId);
}
