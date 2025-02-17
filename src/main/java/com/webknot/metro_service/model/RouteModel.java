package com.webknot.metro_service.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "routes")
public class RouteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long routeId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private boolean active;

    @ManyToMany
    @JoinTable(
            name = "route_stations",
            joinColumns = @JoinColumn(name = "route_id"),
            inverseJoinColumns = @JoinColumn(name = "station_id")
    )
    private List<StationModel> stations;

    @ManyToOne
    @JoinColumn(name = "source_station_id", nullable = false)
    private StationModel sourceStation;

    @ManyToOne
    @JoinColumn(name = "destination_station_id", nullable = false)
    private StationModel destinationStation;

    @Column(nullable = false)
    private double distance;

    @Column(nullable = false)
    private double baseFare;

    public RouteModel() {}

    public RouteModel(String name, boolean active, List<StationModel> stations,
                      StationModel sourceStation, StationModel destinationStation, double distance, double baseFare) {
        this.name = name;
        this.active = active;
        this.stations = stations;
        this.sourceStation = sourceStation;
        this.destinationStation = destinationStation;
        this.distance = distance;
        this.baseFare = baseFare;
    }

    public Long getRouteId() { return routeId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public List<StationModel> getStations() { return stations; }
    public void setStations(List<StationModel> stations) { this.stations = stations; }

    public StationModel getSourceStation() { return sourceStation; }
    public void setSourceStation(StationModel sourceStation) { this.sourceStation = sourceStation; }

    public StationModel getDestinationStation() { return destinationStation; }
    public void setDestinationStation(StationModel destinationStation) { this.destinationStation = destinationStation; }

    public double getDistance() { return distance; }
    public void setDistance(double distance) { this.distance = distance; }

    public double getBaseFare() { return baseFare; }
    public void setBaseFare(double baseFare) { this.baseFare = baseFare; }
}
