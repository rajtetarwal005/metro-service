package com.webknot.metro_service.service;

import com.webknot.metro_service.model.StationModel;
import com.webknot.metro_service.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationService {

    @Autowired
    private StationRepository stationRepository;

    public List<StationModel> getAllStations() {
        return stationRepository.findAll();
    }

    public StationModel getStationById(Long id) {
        return stationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Station not found with id: " + id));
    }

    public StationModel addStation(StationModel station) {
        return stationRepository.save(station);
    }

    public StationModel updateStation(Long id, StationModel stationDetails) {
        StationModel station = getStationById(id);
        station.setName(stationDetails.getName());
        station.setLocation(stationDetails.getLocation());
        station.setActive(stationDetails.isActive());
        return stationRepository.save(station);
    }

    public void deleteStation(Long id) {
        stationRepository.deleteById(id);
    }
}
