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
import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    @Query(value = "SELECT * FROM ticket", nativeQuery = true)
    Page<Ticket> findAllTicket(Pageable pageable);

    @Modifying
    @Query(value = "INSERT INTO ticket (" +
            "ticket_id, " +
            "booking_time, " +
            "customer_name, " +
            "car_license_plate, " +
            "trip_id) VALUES (?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
    void saveTicket(Integer id, Time bookingTime, String customerName, Car lisensePlate, Trip tripId);

    @Query(value = "SELECT * FROM  ticket WHERE license_plate = ?1", nativeQuery = true)
    Optional<Ticket> findTicketById(Integer id);

    @Modifying
    @Query(value = "UPDATE ticket SET booking_time = ?1, customer_name = ?2, car_license_plate = ?3, trip_id = ?4 WHERE ticket_id = ?5", nativeQuery = true)
    void updateTicketById(Time bookingTime, String customerName, Car lisensePlate, Trip tripId, Integer ticketId);

    @Modifying
    @Query(value = "DELETE FROM ticket t WHERE t.ticket_id = ?1", nativeQuery = true)
    void deleteTicketById(Integer id);
}
