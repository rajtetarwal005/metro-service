package com.webknot.metro_service.model;

import jakarta.persistence.*;

@Entity
@Table(name = "station_managers")
public class StationManagerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long managerId;

    @ManyToOne
    @JoinColumn(name = "station_id", nullable = false)
    private StationModel station; // Changed from Station to StationModel

    private String name;
    private String contactNumber;
    private String email;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        ACTIVE, INACTIVE
    }

    // Constructors
    public StationManagerModel() {}

    public StationManagerModel(StationModel station, String name, String contactNumber, String email, Status status) {
        this.station = station;
        this.name = name;
        this.contactNumber = contactNumber;
        this.email = email;
        this.status = status;
    }

    // Getters and Setters
    public Long getManagerId() { return managerId; }
    public void setManagerId(Long managerId) { this.managerId = managerId; }

    public StationModel getStation() { return station; }
    public void setStation(StationModel station) { this.station = station; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
}
