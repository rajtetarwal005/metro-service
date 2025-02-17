package com.webknot.metro_service.repository;

import com.webknot.metro_service.model.StationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepository extends JpaRepository<StationModel, Long> {
}

