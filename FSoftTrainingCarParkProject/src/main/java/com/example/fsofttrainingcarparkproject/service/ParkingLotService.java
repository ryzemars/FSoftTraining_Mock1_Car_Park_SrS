package com.example.fsofttrainingcarparkproject.service;

import com.example.fsofttrainingcarparkproject.entity.ParkingLot;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ParkingLotService {

    Page<ParkingLot> getAllParkingLot(Pageable pageable);

    void insertParkingLot(Integer id, Integer parkArea, String parkName, String parkPlace, Integer parkPrice, String parkStatus);
}
