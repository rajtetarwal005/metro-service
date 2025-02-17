package com.webknot.metro_service.service;

import com.webknot.metro_service.model.CheckOutModel;
import com.webknot.metro_service.repository.CheckOutRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CheckOutServiceImpl implements CheckOutService {

    private final CheckOutRepository checkOutRepository;

    public CheckOutServiceImpl(CheckOutRepository checkOutRepository) {
        this.checkOutRepository = checkOutRepository;
    }

    @Override
    public CheckOutModel createCheckOut(Long checkInId, Long stationId, BigDecimal finalFare) {
        CheckOutModel checkOut = new CheckOutModel();
        checkOut.setCheckInId(checkInId);
        checkOut.setStationId(stationId);
        checkOut.setFinalFare(finalFare);

        return checkOutRepository.save(checkOut);
    }

    @Override
    public List<CheckOutModel> getAllCheckOuts() {
        return checkOutRepository.findAll();
    }
}
