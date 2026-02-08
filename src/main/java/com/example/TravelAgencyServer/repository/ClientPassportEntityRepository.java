package com.example.TravelAgencyServer.repository;

import com.example.TravelAgencyServer.entity.client.ClientPassportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientPassportEntityRepository extends JpaRepository<ClientPassportEntity, Long> {
}
