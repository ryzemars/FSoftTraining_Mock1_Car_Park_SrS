package com.example.fsofttrainingcarparkproject.service;

import com.example.fsofttrainingcarparkproject.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    //native query
    Page<Employee> getAllEmployee(Pageable pageable);

    Optional<Employee> getEmployeeById(Integer id) throws Exception;

    Page<Employee> getEmployeeByName(String name, Pageable pageable);

    void insertEmployee(Integer id, String account, String department, String address, Date birthday, String email, String name, String phone, String password, String sex);

    void modifyEmployeeById(String name, String phone, String address, Integer id);

    void removeEmployeeById(Integer id);

    //void deleteAllEmployee();
}
