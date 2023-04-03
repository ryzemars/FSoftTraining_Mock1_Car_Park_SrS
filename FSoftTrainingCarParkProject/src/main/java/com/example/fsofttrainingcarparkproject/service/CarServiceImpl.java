package com.example.fsofttrainingcarparkproject.service;

import com.example.fsofttrainingcarparkproject.entity.Car;
import com.example.fsofttrainingcarparkproject.entity.ParkingLot;
import com.example.fsofttrainingcarparkproject.repository.CarRepository;
import com.example.fsofttrainingcarparkproject.repository.ParkingLotRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    @Autowired
    ParkingLotRepository parkingLotRepository;

    @Override
    public Page<Car> getAllCar(Pageable pageable) {
        return carRepository.findAllCar(pageable);
    }

    @Override
    public void insertCar(Integer id, String carColor, String carType, String company, ParkingLot parkId) {
        carRepository.saveCar(id, carColor, carType, company, parkId.getParkId());
    }

    @Override
    public void insertCarAndParkingLotAlso(Integer carId, String carColor, String carType, String company, ParkingLot parkId, Integer parkingLotId, Integer parkArea, String parkName, String parkPlace, Integer parkPrice, String parkStatus) {
        //Lưu ý, ở đây phải add ParkingLot trước vì nếu không có parking lot thì sẽ không add được car (lỗi a foreign key constraint fails)
        parkingLotRepository.saveParkingLot(parkingLotId, parkArea, parkName, parkPlace, parkPrice, parkStatus);
        carRepository.saveCar(carId, carColor, carType, company, parkId.getParkId());
    }
}
