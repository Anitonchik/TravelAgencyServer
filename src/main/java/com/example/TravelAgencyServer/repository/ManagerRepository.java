package com.example.TravelAgencyServer.repository;

import com.example.TravelAgencyServer.entity.manager.ManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<ManagerEntity, Long> {
}
