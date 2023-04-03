package com.example.fsofttrainingcarparkproject.service;

import com.example.fsofttrainingcarparkproject.entity.BookingOffice;
import com.example.fsofttrainingcarparkproject.entity.Trip;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface BookingOfficeService {
    //native query
    Page<BookingOffice> getAllBookingOffice(Pageable pageable);

    Page<BookingOffice> getBookingOfficeById(Integer id, Pageable pageable);

    Page<BookingOffice> getBookingOfficeByPlace(String place, Pageable pageable);

    void insertBookingOffice(Integer id, Date endContract, String name, String phone, String place, Integer price, Date beginContract, Trip tripId);

}
