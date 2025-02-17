package com.webknot.metro_service.repository;

import com.webknot.metro_service.model.CheckOutModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckOutRepository extends JpaRepository<CheckOutModel, Long> {
}
