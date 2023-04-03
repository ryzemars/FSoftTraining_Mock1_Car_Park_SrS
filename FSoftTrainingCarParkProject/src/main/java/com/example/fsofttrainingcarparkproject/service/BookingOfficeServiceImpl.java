package com.example.fsofttrainingcarparkproject.service;

import com.example.fsofttrainingcarparkproject.entity.BookingOffice;
import com.example.fsofttrainingcarparkproject.entity.Trip;
import com.example.fsofttrainingcarparkproject.repository.BookingOfficeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Transactional
public class BookingOfficeServiceImpl implements BookingOfficeService{
    @Autowired
    BookingOfficeRepository bookingOfficeRepository;

    @Override
    public Page<BookingOffice> getAllBookingOffice(Pageable pageable) {
        return bookingOfficeRepository.findAllBookingOffice(pageable);
    }

    @Override
    public Page<BookingOffice> getBookingOfficeById(Integer id, Pageable pageable) {
        return bookingOfficeRepository.findBookingOfficeById(id, pageable);
    }

    @Override
    public Page<BookingOffice> getBookingOfficeByPlace(String place, Pageable pageable) {
        return bookingOfficeRepository.findBookingOfficeByPlace(place, pageable);
    }

    @Override
    public void insertBookingOffice(Integer id, Date endContract, String name, String phone, String place, Integer price, Date beginContract, Trip tripId) {
        bookingOfficeRepository.saveBookingOffice(id, endContract, name, phone, place, price, beginContract, tripId);
    }
}
