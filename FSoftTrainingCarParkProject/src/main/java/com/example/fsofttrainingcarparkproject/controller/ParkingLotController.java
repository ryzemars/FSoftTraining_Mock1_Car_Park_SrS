package com.example.fsofttrainingcarparkproject.controller;

import com.example.fsofttrainingcarparkproject.entity.ParkingLot;
import com.example.fsofttrainingcarparkproject.service.ParkingLotService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parking_lot")
public class ParkingLotController {
    @Autowired
    ParkingLotService parkingLotService;

    @GetMapping("list")
    public Page<ParkingLot> getAll(Pageable pageable) {
        return parkingLotService.getAllParkingLot(pageable);
    }

    @PostMapping("add")
    public void insertNew(@Valid @RequestBody ParkingLot parkingLot) {
        System.out.println(parkingLot);
        parkingLotService.insertParkingLot(parkingLot.getParkId(), parkingLot.getParkArea(), parkingLot.getParkName(), parkingLot.getParkPlace(), parkingLot.getParkPrice(), parkingLot.getParkStatus());
    }
}
