package com.example.fsofttrainingcarparkproject.repository;

import com.example.fsofttrainingcarparkproject.entity.BookingOffice;
import com.example.fsofttrainingcarparkproject.entity.Trip;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BookingOfficeRepository extends JpaRepository<BookingOffice, Integer> {
    @Query(value = "SELECT * FROM booking_office", nativeQuery = true)
    Page<BookingOffice> findAllBookingOffice(Pageable pageable);

    @Query(value = "SELECT * FROM  booking_office b WHERE b.office_id = ?1", nativeQuery = true)
    Page<BookingOffice> findBookingOfficeById(Integer id, Pageable pageable);

    @Query(value = "SELECT * FROM  booking_office b WHERE b.office_place LIKE CONCAT('%', ?1, '%')", nativeQuery = true)
    Page<BookingOffice> findBookingOfficeByPlace(String place, Pageable pageable);

    @Modifying
    @Query(value = "INSERT INTO booking_office (" +
            "office_id, " +
            "end_contract_deadline, " +
            "office_name, " +
            "office_phone, " +
            "office_place, " +
            "office_price, " +
            "start_contract_deadline, " +
            "trip_id) VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8)", nativeQuery = true)
    void saveBookingOffice(Integer id, Date endContract, String name, String phone, String place, Integer price, Date beginContract, Trip tripId);

    @Modifying
    @Query(value = "DELETE FROM booking_office WHERE office_id = ?1", nativeQuery = true)
    void deleteById(Integer id);

    @Modifying
    @Query(value = "UPDATE booking_office SET end_contract_deadline = ?1, office_name = ?2, office_phone = ?3, office_place = ?4 WHERE office_id = ?5", nativeQuery = true)
    void updateById(Date endContract, String name, String phone, String place, Integer officeId);
}
