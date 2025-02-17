package com.webknot.metro_service.service;

import com.webknot.metro_service.model.StationManagerModel;

import com.webknot.metro_service.repository.StationManagerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StationManagerService {

    private final StationManagerRepository stationManagerRepository;

    public StationManagerService(StationManagerRepository stationManagerRepository) {
        this.stationManagerRepository = stationManagerRepository;
    }

    public List<StationManagerModel> getAllManagers() {
        return stationManagerRepository.findAll();
    }

    public Optional<StationManagerModel> getManagerById(Long id) {
        return stationManagerRepository.findById(id);
    }

    public StationManagerModel createManager(StationManagerModel stationManager) {
        return stationManagerRepository.save(stationManager);
    }

    public StationManagerModel updateManager(Long id, StationManagerModel updatedManager) {
        return stationManagerRepository.findById(id).map(manager -> {
            manager.setName(updatedManager.getName());
            manager.setContactNumber(updatedManager.getContactNumber());
            manager.setEmail(updatedManager.getEmail());
            manager.setStatus(updatedManager.getStatus());
            return stationManagerRepository.save(manager);
        }).orElseThrow(() -> new RuntimeException("Manager not found"));
    }

    public void deleteManager(Long id) {
        stationManagerRepository.deleteById(id);
    }
}

