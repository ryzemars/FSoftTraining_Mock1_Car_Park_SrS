package com.example.fsofttrainingcarparkproject.entity;

import com.example.fsofttrainingcarparkproject.custom.validator.BirthDate;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
//nguồn tham khảo Spring Validation: https://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/#section-builtin-constraints
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;

    @NotBlank(message = "Không được phép bỏ trống tên")
    //@Pattern(regexp = "^[A-Z](?:'[A-Z])*[a-z]+(?: [A-Z](?:'[A-Z])*[a-z]+)*$", message = "Tên không được bao gồm số và phải viết hoa các ký tự đầu tiên")
    //@Length(max = 5, message = "Tên không được > 6 ký tự")
    private String employeeName;


    @NotNull(message = "The date of birth is required")
    @PastOrPresent(message = "Không được nhập ngày tương lai")
    //TODO: Custom nếu nhỏ hơn 18 tuổi thì in ra phải từ 18 tuổi, nhưng nếu tuổi = số âm thì phải in ra không được nhập ngày tương lai
    @BirthDate(message = "Employee phải đủ 18 tuổi")
    @Temporal(TemporalType.DATE)
    private Date employeeBirthday; // Định dạng dưới DB: yyyy/mm/dd hoặc yyyy-mm-dd

    @Pattern(regexp = "MALE|FEMALE|UNKNOWN", message = "Giới tính phải là MALE, FEMALE hoặc UNKNOWN")
    private String sex;

    private String employeeAddress;

    @Length(max = 10, min = 10, message = "Số điện thoại phải có 10 ký tự")
    @Digits(integer = 128, fraction = 10, message = "số điện thoại phải là số")
    //@Pattern(regexp = "^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$", message = "Sai định dạng số điện thoại")
    private String employeePhone;

    @Email(message = "Email sai định dạng", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    @NotEmpty(message = "Email không được bỏ trống")
    private String employeeEmail;

    @NotBlank(message = "Account không được bỏ trống")
    private String account;

    //@Length(min = 6, message = "Password phải có ít nhất 6 ký tự")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "Password không đúng định dạng, Yêu cầu tối thiểu 8 ký tự, có ít nhất 1 ký tự viết hoa, 1 thường, 1 số, 1 ký tự đặc biệt")
    private String password;

    private String department;

    public Employee() {
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(Date employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", employeeBirthday=" + employeeBirthday +
                ", sex='" + sex + '\'' +
                ", employeeAddress='" + employeeAddress + '\'' +
                ", employeePhone='" + employeePhone + '\'' +
                ", employeeEmail='" + employeeEmail + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
