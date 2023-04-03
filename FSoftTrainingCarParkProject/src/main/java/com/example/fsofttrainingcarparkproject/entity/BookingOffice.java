package com.example.fsofttrainingcarparkproject.entity;

import com.example.fsofttrainingcarparkproject.custom.validator.BookingDate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;

import java.util.Date;

@BookingDate(before = "startContractDeadline", after = "endContractDeadline", message = "Ngày bắt đầu hợp đồng phải < ngày hết hạn hợp đồng")
@Entity
public class BookingOffice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer officeId;

    @NotBlank(message = "Không được phép bỏ trống tên")
    @Pattern(regexp = "^[A-Z](?:'[A-Z])*[a-z]+(?: [A-Z](?:'[A-Z])*[a-z]+)*$", message = "Tên không được bao gồm số và phải viết hoa các ký tự đầu tiên")
    private String officeName;

    @Pattern(regexp = "^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$", message = "Sai định dạng số điện thoại")
    private String officePhone;

    @NotBlank(message = "Không được phép bỏ trống officePlace")
    private String officePlace;

    @NotBlank(message = "Không được phép bỏ trống officePrice")
    private Integer officePrice;

    @Temporal(TemporalType.DATE)
    //@PastOrPresent(message = "start date Không được nhập ngày tương lai")
    //@NotBlank(message = "The date of birth is required")
    private Date startContractDeadline;

    @Temporal(TemporalType.DATE)
    //@PastOrPresent(message = "end date Không được nhập ngày tương lai")
    private Date endContractDeadline;

    /**
     * Entity này có 1 khóa ngoại là tripId liên kết đến Entity Trip → dưới DB: bảng booking_office sẽ có khóa ngoại là trip_id liên kết đến bảng trip
     */
    @ManyToOne
    @JoinColumn (name = "trip_id") // Đặt tên cho cột khóa ngoại là trip_id tại bảng BookingOffice ở dưới DB
    @JsonIgnoreProperties({"hibernateLazyInitializer"})
    private Trip tripId;  //tripId la khoa ngoai den bang Trip

    public BookingOffice() {
    }

    public Integer getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Integer officeId) {
        this.officeId = officeId;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getOfficePlace() {
        return officePlace;
    }

    public void setOfficePlace(String officePlace) {
        this.officePlace = officePlace;
    }

    public Integer getOfficePrice() {
        return officePrice;
    }

    public void setOfficePrice(Integer officePrice) {
        this.officePrice = officePrice;
    }

    public Date getStartContractDeadline() {
        return startContractDeadline;
    }

    public void setStartContractDeadline(Date startContractDeadline) {
        this.startContractDeadline = startContractDeadline;
    }

    public Date getEndContractDeadline() {
        return endContractDeadline;
    }

    public void setEndContractDeadline(Date endContractDeadline) {
        this.endContractDeadline = endContractDeadline;
    }

    public Trip getTripId() {
        return tripId;
    }

    public void setTripId(Trip tripId) {
        this.tripId = tripId;
    }

    @Override
    public String toString() {
        return  "\n" + "BookingOffice{" +
                "officeId=" + officeId +
                ", officeName='" + officeName + '\'' +
                ", officePhone='" + officePhone + '\'' +
                ", officePlace='" + officePlace + '\'' +
                ", officePrice=" + officePrice +
                ", startContractDeadline=" + startContractDeadline +
                ", endContractDeadline=" + endContractDeadline +
                //", tripId=" + tripId +
                '}';
    }
}
