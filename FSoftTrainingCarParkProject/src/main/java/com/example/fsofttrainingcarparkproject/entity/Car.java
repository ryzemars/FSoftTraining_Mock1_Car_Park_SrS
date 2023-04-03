package com.example.fsofttrainingcarparkproject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

import java.util.List;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer licensePlate;

    private String carColor;

    private String carType;

    @Pattern(regexp = "^[A-Z](?:'[A-Z])*[a-z]+(?: [A-Z](?:'[A-Z])*[a-z]+)*$", message = "Tên không được bao gồm số và phải viết hoa các ký tự đầu tiên")
    private String company;

    /**
     * Entity này có 1 Entity tham chiếu đến là Ticket → nó sẽ được map đến Entity Ticket thông qua thuộc tính licensePlate
     * Và Entity này cũng có 1 khóa ngoại là parkingLot liên kết đến Entity ParkingLot được đặt tên là park_id → dưới DB: bảng car sẽ có khóa ngoại là park_id sẽ liên kết đến bảng parking_lot
     */
    @OneToMany(mappedBy = "licensePlate") //licensePlate này là thuộc tính kiểu Car được khai báo ở bên entity Ticket, (không phải thuộc tính licensePlate kiểu Integer ở entity Car này <khai báo ở trên ↖>)
    @JsonBackReference
    private List<Ticket> tickets;

    //khoa ngoai den truong parkId cua entity ParkingLot
    @ManyToOne
    @JoinColumn (name = "park_id") //ở dưới DB: đặt tên cho cột khóa ngoại của bảng parking_lot liên kết với bảng car là park_id
    @JsonIgnoreProperties("hibernateLazyInitializer")
    private ParkingLot parkingLot;

    public Car() {
    }

    public Integer getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(Integer licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    @Override
    public String toString() {
        return "Car{" +
                "licensePlate=" + licensePlate +
                ", carColor='" + carColor + '\'' +
                ", carType='" + carType + '\'' +
                ", company='" + company + '\'' +
                ", tickets=" + tickets +
                //", parkingLot=" + parkingLot +
                '}';
    }
}
