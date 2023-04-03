package com.example.fsofttrainingcarparkproject.controller;

import com.example.fsofttrainingcarparkproject.entity.Car;
import com.example.fsofttrainingcarparkproject.service.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping("list")
    private Page<Car> getAll(Pageable pageable) {
        return carService.getAllCar(pageable);
    }

    @PostMapping("add")
    private void addNew(@Valid @RequestBody Car car) {
        System.out.println(car);
        carService.insertCar(car.getLicensePlate(), car.getCarColor(), car.getCarType(), car.getCompany(), car.getParkingLot());
    }

    @PostMapping("add-car-and-parking-lot")
    private void addCarAndParkingLot(@Valid @RequestBody Car car) {
        carService.insertCarAndParkingLotAlso(
                car.getLicensePlate(),
                car.getCarColor(),
                car.getCarType(),
                car.getCompany(),
                car.getParkingLot(),
                car.getParkingLot().getParkId(),
                car.getParkingLot().getParkArea(),
                car.getParkingLot().getParkName(),
                car.getParkingLot().getParkPlace(),
                car.getParkingLot().getParkPrice(),
                car.getParkingLot().getParkStatus());
    }
}
