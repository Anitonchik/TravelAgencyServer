package com.example.TravelAgencyServer.repository;

import com.example.TravelAgencyServer.entity.client.CMIPolicyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CMIPolicyRepository extends JpaRepository<CMIPolicyEntity, Long> {
}
