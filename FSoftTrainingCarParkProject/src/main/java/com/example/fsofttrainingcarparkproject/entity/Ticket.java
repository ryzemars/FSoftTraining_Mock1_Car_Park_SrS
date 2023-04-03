package com.example.fsofttrainingcarparkproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.sql.Time;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketId;

    @NotBlank(message = "Không được phép bỏ trống tên")
    @Pattern(regexp = "^[A-Z](?:'[A-Z])*[a-z]+(?: [A-Z](?:'[A-Z])*[a-z]+)*$", message = "Tên không được bao gồm số và phải viết hoa các ký tự đầu tiên")
    private String customerName;

    @Temporal(TemporalType.TIME)
    @FutureOrPresent(message = "Không được nhập ngày trong qúa khứ")
    private Time bookingTime;

    /**
     * Entity này có khóa ngoại là tripId liên kết đến Entity Trip → dưới DB: bảng ticket có khóa ngoại là trip_id sẽ liên kết đến bảng trip
     * Và 1 khóa ngoại khác là licensePlate liên kết đến Entity Car → dưới DB: 1 cột khóa ngoại nữa là car_license_plate sẽ liên kết đến bảng car
     */
    @ManyToOne
    //tại bảng ticket ở dưới DB → đặt tên cho cột khóa ngoại liên kết đến bảng trip là trip_id
    @JoinColumn(name = "trip_id")
    @JsonIgnoreProperties("hibernateLazyInitializer")
    private Trip tripId;

    @ManyToOne
    //tương tự, đặt tên cho cột khóa ngoại liên kết với bảng car là car_license_plate
    @JoinColumn(name = "car_license_plate")
    @JsonIgnoreProperties("hibernateLazyInitializer")
    private Car licensePlate;

    public Ticket() {
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Time getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Time bookingTime) {
        this.bookingTime = bookingTime;
    }

    public Trip getTripId() {
        return tripId;
    }

    public void setTripId(Trip tripId) {
        this.tripId = tripId;
    }

    public Car getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(Car licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public String toString() {
        return "\n" + "Ticket{" +
                "ticketId=" + ticketId +
                ", customerName='" + customerName + '\'' +
                ", bookingTime=" + bookingTime +
                //", tripId=" + tripId +
                //", licensePlate=" + licensePlate +
                '}';
    }
}
