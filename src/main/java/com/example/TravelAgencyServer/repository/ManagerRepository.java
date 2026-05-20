package com.example.TravelAgencyServer.repository;

import com.example.TravelAgencyServer.entity.manager.ManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ManagerRepository extends JpaRepository<ManagerEntity, Long> {
    Optional<ManagerEntity> findByLogin(String login);
}
