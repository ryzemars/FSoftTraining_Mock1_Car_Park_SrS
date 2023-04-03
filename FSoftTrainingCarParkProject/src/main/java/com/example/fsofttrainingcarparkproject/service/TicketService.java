package com.example.fsofttrainingcarparkproject.service;

import com.example.fsofttrainingcarparkproject.entity.Car;
import com.example.fsofttrainingcarparkproject.entity.Ticket;
import com.example.fsofttrainingcarparkproject.entity.Trip;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Time;
import java.util.List;

public interface TicketService {

    Page<Ticket> getAllTicket(Pageable pageable);

    void insertTicket(Integer id, Time bookingTime, String customerName, Car lisensePlate, Trip tripId);

    void removeTicketById(Integer id);

}
