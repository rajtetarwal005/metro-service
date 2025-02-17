package com.webknot.metro_service.controller;

import com.webknot.metro_service.model.StationModel;
import com.webknot.metro_service.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stations")
public class StationController {

    @Autowired
    private StationService stationService;

    // Get all stations
    @GetMapping
    public List<StationModel> getAllStations() {
        return stationService.getAllStations();
    }

    // Get station by ID
    @GetMapping("/{id}")
    public StationModel getStationById(@PathVariable Long id) {
        return stationService.getStationById(id);
    }

    // Add new station
    @PostMapping
    public StationModel  addStation(@RequestBody StationModel station) {
        return stationService.addStation(station);
    }

    // Update station
    @PutMapping("/{id}")
    public StationModel updateStation(@PathVariable Long id, @RequestBody StationModel station) {
        return stationService.updateStation(id, station);
    }

    // Delete station
    @DeleteMapping("/{id}")
    public String deleteStation(@PathVariable Long id) {
        stationService.deleteStation(id);
        return "Station deleted successfully!";
    }
}

