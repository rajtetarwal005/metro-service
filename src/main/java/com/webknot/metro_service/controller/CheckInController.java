package com.webknot.metro_service.controller;

import com.webknot.metro_service.model.CheckInModel;
import com.webknot.metro_service.service.CheckInService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/check-ins")
public class CheckInController {

    private final CheckInService checkInService;

    public CheckInController(CheckInService checkInService) {
        this.checkInService = checkInService;
    }

    @GetMapping
    public List<CheckInModel> getAllCheckIns() {
        return checkInService.getAllCheckIns();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CheckInModel> getCheckInById(@PathVariable Long id) {
        Optional<CheckInModel> checkIn = checkInService.getCheckInById(id);
        return checkIn.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CheckInModel> createCheckIn(@RequestBody CheckInModel checkIn) {
        CheckInModel savedCheckIn = checkInService.createCheckIn(checkIn);
        return ResponseEntity.ok(savedCheckIn);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CheckInModel> updateCheckIn(@PathVariable Long id, @RequestBody CheckInModel updatedCheckIn) {
        try {
            CheckInModel updated = checkInService.updateCheckIn(id, updatedCheckIn);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCheckIn(@PathVariable Long id) {
        checkInService.deleteCheckIn(id);
        return ResponseEntity.noContent().build();
    }
}
