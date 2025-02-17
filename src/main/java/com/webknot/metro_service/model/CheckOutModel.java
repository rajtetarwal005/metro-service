package com.webknot.metro_service.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "check_outs")
public class CheckOutModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long checkInId;
    private Long stationId;
    private BigDecimal finalFare;

    @Column(nullable = false, updatable = false)
    private LocalDateTime checkOutTime;

    // Default constructor (required for JPA)
    public CheckOutModel() {
        this.checkOutTime = LocalDateTime.now(); // Automatically set checkout time
    }

    //  Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCheckInId() {
        return checkInId;
    }

    public void setCheckInId(Long checkInId) {
        this.checkInId = checkInId;
    }

    public Long getStationId() {
        return stationId;
    }

    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }

    public BigDecimal getFinalFare() {
        return finalFare;
    }

    public void setFinalFare(BigDecimal finalFare) {
        this.finalFare = finalFare;
    }

    public LocalDateTime getCheckOutTime() {
        return checkOutTime;
    }
}
