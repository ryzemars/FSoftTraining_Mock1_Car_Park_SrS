package com.example.fsofttrainingcarparkproject.controller;

import com.example.fsofttrainingcarparkproject.entity.Trip;
import com.example.fsofttrainingcarparkproject.service.TripService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trip")
public class TripController {
    @Autowired
    TripService tripService;

    //1
    @GetMapping("list")
    private Page<Trip> getAll(Pageable pageable) {
        System.out.println(tripService.getAllTrip(pageable));
        return tripService.getAllTrip(pageable);
    }

    //2
    @GetMapping("find/{id}")
    private Page<Trip> getById(@PathVariable Integer id, Pageable pageable) {
        return tripService.getTripById(id, pageable);
    }

    //3
    @GetMapping("find")
    private Page<Trip> getByTicketNumber(@RequestParam("ticket_number") Integer ticketNumber, Pageable pageable) {
        return tripService.getTripByTicketNumber(ticketNumber, pageable);
    }

    //4
    @PostMapping("add")
    private void addTrip(@Valid @RequestBody Trip trip) {
        System.out.println(trip);
        tripService.insertTrip(
                trip.getTripId(),
                trip.getBookedTicketNumber(),
                trip.getCarType(),
                trip.getDepartureDate(),
                trip.getDepartureTime(),
                trip.getDestination(),
                trip.getDriver(),
                trip.getMaximumOnlineTicketNumber());
    }
}
