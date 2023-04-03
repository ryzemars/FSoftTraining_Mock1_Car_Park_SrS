package com.example.fsofttrainingcarparkproject.service;

import com.example.fsofttrainingcarparkproject.entity.Car;
import com.example.fsofttrainingcarparkproject.entity.Ticket;
import com.example.fsofttrainingcarparkproject.entity.Trip;
import com.example.fsofttrainingcarparkproject.repository.TicketRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public Page<Ticket> getAllTicket(Pageable pageable) {
        return ticketRepository.findAllTicket(pageable);
    }

    @Override
    public void insertTicket(Integer id, Time bookingTime, String customerName, Car lisensePlate, Trip tripId) {
        ticketRepository.saveTicket(id, bookingTime, customerName, lisensePlate, tripId);
    }

    @Override
    public void removeTicketById(Integer id) {
        ticketRepository.deleteTicketById(id);
    }

}
