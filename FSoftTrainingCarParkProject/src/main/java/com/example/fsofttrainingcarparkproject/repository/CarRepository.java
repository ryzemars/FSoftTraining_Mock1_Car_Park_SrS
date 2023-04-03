package com.example.fsofttrainingcarparkproject.repository;

import com.example.fsofttrainingcarparkproject.entity.Car;
import com.example.fsofttrainingcarparkproject.entity.ParkingLot;
import com.example.fsofttrainingcarparkproject.entity.Ticket;
import com.example.fsofttrainingcarparkproject.entity.Trip;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {
    @Query(value = "SELECT * FROM car", nativeQuery = true)
    Page<Car> findAllCar(Pageable pageable);

    @Modifying
    @Query(value = "INSERT INTO car (" +
            "license_plate, " +
            "car_color, " +
            "car_type, " +
            "company, " +
            "park_id) VALUES (?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
    void saveCar(Integer id, String carColor, String carType, String company, Integer parkId);

    @Query(value = "SELECT * FROM  car WHERE license_plate = ?1", nativeQuery = true)
    Optional<Car> findCarById(Integer id);

    @Modifying
    @Query(value = "DELETE FROM car WHERE license_plate = ?1", nativeQuery = true)
    void deleteCarById(Integer id);

    @Modifying
    @Query(value = "UPDATE car SET car_color = ?1, car_type = ?2, company = ?3, park_id = ?4 WHERE license_plate = ?5", nativeQuery = true)
    void updateCarById(String carColor, String carType, String company, ParkingLot parkId, Integer lisencePlate);
}
