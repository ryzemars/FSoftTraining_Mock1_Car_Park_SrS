package com.example.fsofttrainingcarparkproject.controller;

import com.example.fsofttrainingcarparkproject.entity.BookingOffice;
import com.example.fsofttrainingcarparkproject.service.BookingOfficeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("booking_office")
@Validated
public class BookingOfficeController {

    @Autowired
    BookingOfficeService bookingOfficeService;

    //1
    @GetMapping("list")
    private Page<BookingOffice> getAll(Pageable pageable) {
        return bookingOfficeService.getAllBookingOffice(pageable);
    }

    //2
    @GetMapping("find/{id}")
    private Page<BookingOffice> getById(@PathVariable Integer id, Pageable pageable) {
        System.out.println(bookingOfficeService.getBookingOfficeById(id, pageable));
        return bookingOfficeService.getBookingOfficeById(id, pageable);
    }

    //3
    @GetMapping("find")
    private Page<BookingOffice> getByPlace(@RequestParam("place") String place, Pageable pageable) {
        return bookingOfficeService.getBookingOfficeByPlace(place, pageable);
    }

    //4
    @PostMapping("add")
    private void addBookingOffice(@RequestBody @Valid BookingOffice bookingOffice) {
        System.out.println(bookingOffice);
        bookingOfficeService.insertBookingOffice(
                bookingOffice.getOfficeId(),
                bookingOffice.getEndContractDeadline(),
                bookingOffice.getOfficeName(),
                bookingOffice.getOfficePhone(),
                bookingOffice.getOfficePlace(),
                bookingOffice.getOfficePrice(),
                bookingOffice.getStartContractDeadline(),
                bookingOffice.getTripId());
    }
}
