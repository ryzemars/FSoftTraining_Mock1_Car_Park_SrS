package com.example.fsofttrainingcarparkproject.controller;

import com.example.fsofttrainingcarparkproject.entity.BookingOffice;
import com.example.fsofttrainingcarparkproject.entity.Ticket;
import com.example.fsofttrainingcarparkproject.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;

    //1
    @GetMapping("list")
    private Page<Ticket> getAll(Pageable pageable) {
        return ticketService.getAllTicket(pageable);
    }

    //2
    @PostMapping("add")
    private void addNew(@Valid  @RequestBody Ticket ticket) {
        System.out.println(ticket);
        ticketService.insertTicket(ticket.getTicketId(), ticket.getBookingTime(), ticket.getCustomerName(), ticket.getLicensePlate(), ticket.getTripId());
    }

    //3
    @DeleteMapping("delete/{id}")
    private void removeById(@PathVariable Integer id) {
        ticketService.removeTicketById(id);
    }
}
