package com.example.fsofttrainingcarparkproject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tripId;

    private String carType;

    @NotBlank(message = "Không được phép bỏ trống tên")
    @Pattern(regexp = "^[A-Z](?:'[A-Z])*[a-z]+(?: [A-Z](?:'[A-Z])*[a-z]+)*$", message = "Tên không được bao gồm số và phải viết hoa các ký tự đầu tiên")
    private String driver;

    private String destination;

    @Temporal(TemporalType.DATE)
    @FutureOrPresent(message = "Không được nhập ngày trong qúa khứ")
    private Date departureDate;

    @Temporal(TemporalType.TIME)
    @FutureOrPresent(message = "Không được nhập ngày trong qúa khứ")
    private Date departureTime;

    private Integer bookedTicketNumber;

    private Integer maximumOnlineTicketNumber;

    /**
     * Entity này có 2 Entity cùng tham chiếu đến là Ticket và BookingOffice
     * → nó sẽ được map đến Entity Ticket thông qua thuộc tính tripId - tripId này được khai báo bên Entity Ticket
     * Và được map đến Entity BookingOffice cũng thông qua thuộc tính tripId nhưng được khai báo bên Entity BookingOffice
     */
    // Khi 1 entity dùng 2 @JsonBackReference thì phải chỉ rõ value nếu không thì phương thức ở Controller sẽ không thể nhận được PostRequest có Body raw Json được gửi từ PostMan
    // Failed to evaluate Jackson deserialization for type... Multiple back-reference properties with name 'defaultReference'
    @OneToMany(mappedBy = "tripId") //tripId này là thuộc tính kiểu Ticket được khai báo ở bên entity Ticket, (không phải thuộc tính tripId kiểu Integer ở entity này ↖)
    @JsonBackReference (value = "ticket")
    private List<Ticket> tickets = new ArrayList<>(); //Cách 2

    @OneToMany(mappedBy = "tripId") //tripId này là thuộc tính kiểu Trip được khai báo ở bên entity BookingOffice, (không phải thuộc tính tripId kiểu Integer ở entity này ↖)
    @JsonBackReference (value = "booking_office")
    private List<BookingOffice> bookingOffices; //Cách 1

    public Trip() {
    }

    public Integer getTripId() {
        return tripId;
    }

    public void setTripId(Integer tripId) {
        this.tripId = tripId;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Integer getBookedTicketNumber() {
        return bookedTicketNumber;
    }

    public void setBookedTicketNumber(Integer bookedTicketNumber) {
        this.bookedTicketNumber = bookedTicketNumber;
    }

    public Integer getMaximumOnlineTicketNumber() {
        return maximumOnlineTicketNumber;
    }

    public void setMaximumOnlineTicketNumber(Integer maximumOnlineTicketNumber) {
        this.maximumOnlineTicketNumber = maximumOnlineTicketNumber;
    }

    public List<BookingOffice> getBookingOffices() {
        return bookingOffices;
    }

    public void setBookingOffices(List<BookingOffice> bookingOffices) {
        this.bookingOffices = bookingOffices;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "Trip{" + "\n" +
                "tripId=" + tripId + "\n" +
                ", carType='" + carType + '\'' + "\n" +
                ", driver='" + driver + '\'' + "\n" +
                ", destination='" + destination + '\'' + "\n" +
                ", departureDate=" + departureDate + "\n" +
                ", departureTime=" + departureTime + "\n" +
                ", bookedTicketNumber=" + bookedTicketNumber + "\n" +
                ", maximumOnlineTicketNumber=" + maximumOnlineTicketNumber + "\n" +
                ", tickets=" + tickets + "\n" +
                ", bookingOffices=" + bookingOffices + '}' + "\n";
    }
}
