package com.example.fsofttrainingcarparkproject.service;

import com.example.fsofttrainingcarparkproject.entity.Employee;
import com.example.fsofttrainingcarparkproject.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Page<Employee> getAllEmployee(Pageable pageable) {
        return employeeRepository.findAllEmployee(pageable);
    }

    @Override
    public Optional<Employee> getEmployeeById(Integer id) throws Exception {
        Optional<Employee> employee = employeeRepository.findEmployeeById(id);
        if(employee.isEmpty())
            throw new Exception("No employee found!");
        else
            return employee;
    }

    @Override
    public Page<Employee> getEmployeeByName(String name, Pageable pageable) {
        return employeeRepository.findEmployeeByName(name, pageable);
    }

    @Override
    public void insertEmployee(Integer id, String account, String department, String address, Date birthday, String email, String name, String phone, String password, String sex) {
        employeeRepository.saveEmployee(id, account, department, address, birthday, email, name, phone, password, sex);
    }

    @Override
    public void modifyEmployeeById(String name, String phone, String address, Integer id) {
        employeeRepository.updateEmployeeById(name, phone, address, id);
    }

    @Override
    public void removeEmployeeById(Integer id) {
        employeeRepository.deleteEmployeeById(id);
    }


}
