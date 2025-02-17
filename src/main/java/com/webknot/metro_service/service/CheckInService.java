package com.webknot.metro_service.service;

import com.webknot.metro_service.model.CheckInModel;
import com.webknot.metro_service.repository.CheckInRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CheckInService {

    private final CheckInRepository checkInRepository;

    public CheckInService(CheckInRepository checkInRepository) {
        this.checkInRepository = checkInRepository;
    }

    public List<CheckInModel> getAllCheckIns() {
        return checkInRepository.findAll();
    }

    public Optional<CheckInModel> getCheckInById(Long id) {
        return checkInRepository.findById(id);
    }

    public CheckInModel createCheckIn(CheckInModel checkIn) {
        return checkInRepository.save(checkIn);
    }

    public CheckInModel updateCheckIn(Long id, CheckInModel updatedCheckIn) {
        return checkInRepository.findById(id).map(existingCheckIn -> {
            existingCheckIn.setUserId(updatedCheckIn.getUserId());
            existingCheckIn.setStation(updatedCheckIn.getStation());
            existingCheckIn.setTicketType(updatedCheckIn.getTicketType());
            existingCheckIn.setTicketId(updatedCheckIn.getTicketId());
            existingCheckIn.setCheckInTime(updatedCheckIn.getCheckInTime());
            existingCheckIn.setStatus(updatedCheckIn.getStatus());
            return checkInRepository.save(existingCheckIn);
        }).orElseThrow(() -> new RuntimeException("Check-In not found"));
    }

    public void deleteCheckIn(Long id) {
        checkInRepository.deleteById(id);
    }
}
