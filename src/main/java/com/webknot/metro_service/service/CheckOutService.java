package com.webknot.metro_service.service;

import com.webknot.metro_service.model.CheckOutModel;
import java.math.BigDecimal;
import java.util.List;

public interface CheckOutService {
    CheckOutModel createCheckOut(Long checkInId, Long stationId, BigDecimal finalFare);
    List<CheckOutModel> getAllCheckOuts();
}
