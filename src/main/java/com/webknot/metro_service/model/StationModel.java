package com.webknot.metro_service.model;

import jakarta.persistence.*;

@Entity
@Table(name = "stations")
public class StationModel {  // Changed name
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "station_id")  // Ensure column name matches DB schema
    private Long stationId;



    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private boolean isActive;

    public StationModel() {}

    public StationModel(String name, String location, boolean isActive) {
        this.name = name;
        this.location = location;
        this.isActive = isActive;
    }

    public Long getStationId() {
        return stationId;
    }

    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
