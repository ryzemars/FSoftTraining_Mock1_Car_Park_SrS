package com.example.fsofttrainingcarparkproject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.List;

@Entity
public class ParkingLot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer parkId;

    @Pattern(regexp = "^[A-Z](?:'[A-Z])*[a-z]+(?: [A-Z](?:'[A-Z])*[a-z]+)*$", message = "Tên không được bao gồm số và phải viết hoa các ký tự đầu tiên")
    private Integer parkArea;

    @NotBlank(message = "Không được phép bỏ trống tên")
    @Pattern(regexp = "^[A-Z](?:'[A-Z])*[a-z]+(?: [A-Z](?:'[A-Z])*[a-z]+)*$", message = "Tên không được bao gồm số và phải viết hoa các ký tự đầu tiên")
    private String parkName;

    @Pattern(regexp = "^[A-Z](?:'[A-Z])*[a-z]+(?: [A-Z](?:'[A-Z])*[a-z]+)*$", message = "Tên không được bao gồm số và phải viết hoa các ký tự đầu tiên")
    private String parkPlace;

    private Integer parkPrice;

    private String parkStatus;

    //One to Many sử dung cascade, cần dùng thì mở cmt ra. Kết hợp với @JoinColumn chứa không dùng mappedBy
    //TODO: ở đây Tuấn có dùng CascadeType.PERSIST, mappedBy = "parkingLot" kết hợp với JsonIgnore → tìm hiểu cách dùng Cascade ntn⁈
    //@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    //@JoinColumn(name = "park_id") //park_id này là park_id của bảng car, không phải park_id của bảng parking_lot

    @OneToMany(mappedBy = "parkingLot") //parkingLot này là thuộc tính kiểu ParkingLot được khai báo ở bên entity Car, (không phải thuộc tính parkId kiểu Integer khai báo ở trên ↖)
    @JsonBackReference
    private List<Car> cars;

    public ParkingLot() {
    }

    public Integer getParkId() {
        return parkId;
    }

    public void setParkId(Integer parkId) {
        this.parkId = parkId;
    }

    public Integer getParkArea() {
        return parkArea;
    }

    public void setParkArea(Integer parkArea) {
        this.parkArea = parkArea;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public String getParkPlace() {
        return parkPlace;
    }

    public void setParkPlace(String parkPlace) {
        this.parkPlace = parkPlace;
    }

    public Integer getParkPrice() {
        return parkPrice;
    }

    public void setParkPrice(Integer parkPrice) {
        this.parkPrice = parkPrice;
    }

    public String getParkStatus() {
        return parkStatus;
    }

    public void setParkStatus(String parkStatus) {
        this.parkStatus = parkStatus;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "parkId=" + parkId +
                ", parkArea=" + parkArea +
                ", parkName='" + parkName + '\'' +
                ", parkPlace='" + parkPlace + '\'' +
                ", parkPrice=" + parkPrice +
                ", parkStatus='" + parkStatus + '\'' +
                ", cars=" + cars +
                '}';
    }
}
