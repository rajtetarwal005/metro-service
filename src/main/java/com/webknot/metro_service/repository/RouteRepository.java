package com.webknot.metro_service.repository;

import com.webknot.metro_service.model.RouteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<RouteModel, Long> {
}
