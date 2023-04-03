package com.example.fsofttrainingcarparkproject.service;

import com.example.fsofttrainingcarparkproject.entity.Car;
import com.example.fsofttrainingcarparkproject.entity.ParkingLot;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CarService {

    Page<Car> getAllCar(Pageable pageable);

    void insertCar(Integer id, String carColor, String carType, String company, ParkingLot parkId);

    void insertCarAndParkingLotAlso(Integer carId, String carColor, String carType, String company, ParkingLot parkId, Integer parkingLotId, Integer parkArea, String parkName, String parkPlace, Integer parkPrice, String parkStatus);
}
