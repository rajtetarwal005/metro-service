package com.webknot.metro_service.controller;

import com.webknot.metro_service.model.CheckOutModel;
import com.webknot.metro_service.service.CheckOutService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/check-outs")
public class CheckOutController {

    private final CheckOutService checkOutService;

    public CheckOutController(CheckOutService checkOutService) {
        this.checkOutService = checkOutService;
    }

    // GET Request: Fetch all check-outs
    @GetMapping
    public ResponseEntity<List<CheckOutModel>> getAllCheckOuts() {
        List<CheckOutModel> checkOuts = checkOutService.getAllCheckOuts();
        return ResponseEntity.ok(checkOuts);
    }

    //  POST Request: Create a new check-out
    @PostMapping
    public ResponseEntity<CheckOutModel> createCheckOut(@RequestBody Map<String, Object> requestBody) {
        Long checkInId = Long.valueOf(requestBody.get("checkInId").toString());
        Long stationId = Long.valueOf(requestBody.get("stationId").toString());
        BigDecimal finalFare = new BigDecimal(requestBody.get("finalFare").toString());

        CheckOutModel checkOut = checkOutService.createCheckOut(checkInId, stationId, finalFare);
        return ResponseEntity.ok(checkOut);
    }
}
