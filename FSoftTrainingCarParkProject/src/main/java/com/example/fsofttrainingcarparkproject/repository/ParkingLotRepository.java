package com.example.fsofttrainingcarparkproject.repository;

import com.example.fsofttrainingcarparkproject.entity.Car;
import com.example.fsofttrainingcarparkproject.entity.Employee;
import com.example.fsofttrainingcarparkproject.entity.ParkingLot;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParkingLotRepository extends JpaRepository<ParkingLot, Integer> {
    @Query(value = "SELECT * FROM parking_lot", nativeQuery = true)
    Page<ParkingLot> findAllParkingLot(Pageable pageable);

    @Modifying
    @Query(value = "INSERT INTO parking_lot (" +
            "park_id, " +
            "park_area, " +
            "park_name, " +
            "park_place, " +
            "park_price, " +
            "park_status) VALUES (?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
    void saveParkingLot(Integer id, Integer parkArea, String parkName, String parkPlace, Integer parkPrice, String parkStatus);

    @Query(value = "SELECT * FROM  parking_lot WHERE park_id = ?1", nativeQuery = true)
    Optional<ParkingLot> findParkingLotById(Integer id);

    @Modifying
    @Query(value = "DELETE FROM parking_lot WHERE park_id = ?1", nativeQuery = true)
    void deleteParkingLotById(Integer id);

    @Modifying
    @Query(value = "UPDATE parking_lot SET park_area = ?1, park_name = ?2, park_place = ?3, park_price = ?4, park_status = ?5 WHERE park_id = ?6", nativeQuery = true)
    void updateParkingLotById(Integer parkArea, String parkName, String parkPlace, Integer parkPrice, String parkStatus, Integer parkId);
}
