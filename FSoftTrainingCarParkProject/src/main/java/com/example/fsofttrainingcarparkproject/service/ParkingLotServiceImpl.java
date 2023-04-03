package com.example.fsofttrainingcarparkproject.service;

import com.example.fsofttrainingcarparkproject.entity.ParkingLot;
import com.example.fsofttrainingcarparkproject.repository.ParkingLotRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ParkingLotServiceImpl implements ParkingLotService{

    @Autowired
    ParkingLotRepository parkingLotRepository;

    @Override
    public Page<ParkingLot> getAllParkingLot(Pageable pageable) {
        return parkingLotRepository.findAllParkingLot(pageable);
    }

    @Override
    public void insertParkingLot(Integer id, Integer parkArea, String parkName, String parkPlace, Integer parkPrice, String parkStatus) {
        parkingLotRepository.saveParkingLot(id, parkArea, parkName, parkPlace, parkPrice, parkStatus);
    }
}
