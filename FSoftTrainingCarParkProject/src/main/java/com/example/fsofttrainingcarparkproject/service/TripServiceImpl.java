package com.example.fsofttrainingcarparkproject.service;

import com.example.fsofttrainingcarparkproject.entity.Trip;
import com.example.fsofttrainingcarparkproject.repository.TripRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TripServiceImpl implements TripService{

    @Autowired
    TripRepository tripRepository;

    @Override
    public Page<Trip> getAllTrip(Pageable pageable) {
        return tripRepository.findAllTrip(pageable);
    }

    @Override
    public Page<Trip> getTripById(Integer id, Pageable pageable) {
        return tripRepository.findTripById(id, pageable);
    }

    @Override
    public Page<Trip> getTripByTicketNumber(Integer ticketNumber, Pageable pageable) {
        return tripRepository.findTripByTicketNumber(ticketNumber, pageable);
    }

    @Override
    public void insertTrip(Integer id, Integer ticketNumber, String carType, Date departureDate, Date departureTime, String destination, String driver, Integer maxTicket) {
        tripRepository.saveTrip(id, ticketNumber, carType, departureDate, departureTime, destination, driver, maxTicket);
    }
}
