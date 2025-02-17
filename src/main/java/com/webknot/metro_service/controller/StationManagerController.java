package com.webknot.metro_service.controller;

import com.webknot.metro_service.model.StationManagerModel;
import com.webknot.metro_service.service.StationManagerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/station-managers")
public class StationManagerController {

    private final StationManagerService stationManagerService;

    public StationManagerController(StationManagerService stationManagerService) {
        this.stationManagerService = stationManagerService;
    }

    @GetMapping
    public List<StationManagerModel> getAllManagers() {
        return stationManagerService.getAllManagers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StationManagerModel> getManagerById(@PathVariable Long id) {
        Optional<StationManagerModel> manager = stationManagerService.getManagerById(id);
        return manager.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<StationManagerModel> createManager(@RequestBody StationManagerModel stationManager) {
        StationManagerModel savedManager = stationManagerService.createManager(stationManager);
        return ResponseEntity.ok(savedManager);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StationManagerModel> updateManager(@PathVariable Long id, @RequestBody StationManagerModel updatedManager) {
        try {
            StationManagerModel updated = stationManagerService.updateManager(id, updatedManager);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteManager(@PathVariable Long id) {
        stationManagerService.deleteManager(id);
        return ResponseEntity.noContent().build();
    }
}

