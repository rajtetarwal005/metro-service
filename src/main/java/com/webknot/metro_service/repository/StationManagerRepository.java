package com.webknot.metro_service.repository;

import com.webknot.metro_service.model.StationManagerModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StationManagerRepository extends JpaRepository<StationManagerModel, Long> {
    List<StationManagerModel> findByStatus(StationManagerModel.Status status);
}

