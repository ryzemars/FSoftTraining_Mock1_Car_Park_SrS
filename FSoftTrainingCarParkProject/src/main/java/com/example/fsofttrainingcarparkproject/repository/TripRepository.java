package com.example.fsofttrainingcarparkproject.repository;

import com.example.fsofttrainingcarparkproject.entity.Car;
import com.example.fsofttrainingcarparkproject.entity.Ticket;
import com.example.fsofttrainingcarparkproject.entity.Trip;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface TripRepository extends JpaRepository<Trip, Integer> {
    @Query(value = "SELECT * FROM trip", nativeQuery = true)
    Page<Trip> findAllTrip(Pageable pageable);

    @Query(value = "SELECT * FROM  trip t WHERE t.trip_id = ?1", nativeQuery = true)
    Page<Trip> findTripById(Integer id, Pageable pageable);

    @Query(value = "SELECT * FROM  trip t WHERE t.booked_ticket_number = ?1", nativeQuery = true)
    Page<Trip> findTripByTicketNumber(Integer ticketNumber, Pageable pageable);

    @Modifying
    @Query(value = "INSERT INTO trip (" +
            "trip_id, " +
            "booked_ticket_number, " +
            "car_type, " +
            "departure_date, " +
            "departure_time, " +
            "destination, " +
            "driver, " +
            "maximum_online_ticket_number) VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8)", nativeQuery = true)
    void saveTrip(Integer id, Integer ticketNumber, String carType, Date departureDate, Date departureTime, String destination, String driver, Integer maxTicket);


    @Modifying
    @Query(value = "UPDATE trip SET booked_ticket_number = ?1, car_type = ?2, departure_date = ?3, departure_time = ?4, destination= ?5, driver = ?6 WHERE trip_id = ?7", nativeQuery = true)
    void updateById(Integer ticketNumber, String carType, Date departureDate, Date departureTime, String destination, String driver, Integer tripId);

    @Modifying
    @Query(value = "DELETE FROM trip t WHERE t.trip_id = ?1", nativeQuery = true)
    void deletetById(Integer id);
}
