package com.example.fsofttrainingcarparkproject.service;

import com.example.fsofttrainingcarparkproject.entity.Employee;
import com.example.fsofttrainingcarparkproject.entity.Trip;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface TripService {

    Page<Trip> getAllTrip(Pageable pageable);

    Page<Trip> getTripById(Integer id, Pageable pageable);

    Page<Trip> getTripByTicketNumber(Integer ticketNumber, Pageable pageable);

    void insertTrip(Integer id, Integer ticketNumber, String carType, Date departureDate, Date departureTime, String destination, String driver, Integer maxTicket);
}
