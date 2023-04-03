package com.example.fsofttrainingcarparkproject.controller;

import com.example.fsofttrainingcarparkproject.entity.Employee;
import com.example.fsofttrainingcarparkproject.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    //1
    @GetMapping("list")
    private Page<Employee> getAll(Pageable pageable) {
        return employeeService.getAllEmployee(pageable);
    }

    //2
    @GetMapping("find/{id}")
    private Optional<Employee> getById(@PathVariable Integer id) throws Exception {
        return employeeService.getEmployeeById(id);
    }

    //TODO: Hỏi xem ngoài cách dùng if else để check như 3.2 thì còn cách khác không?
    // ⇉ Dùng Optional, hoặc dùng 1 GetMapping nữa kết hợp với PathVariable
    //3.2
    @GetMapping("findbyname")
    private Page<Employee> getByName(@RequestParam("name") String name, Pageable pageable) {
        return employeeService.getEmployeeByName(name, pageable);
    }

    //4
    @PostMapping("add")
    private void addEmployee(@RequestBody @Valid Employee employee) {
        employeeService.insertEmployee(
                employee.getEmployeeId(),
                employee.getAccount(),
                employee.getDepartment(),
                employee.getEmployeeAddress(),
                employee.getEmployeeBirthday(),
                employee.getEmployeeEmail(),
                employee.getEmployeeName(),
                employee.getEmployeePhone(),
                employee.getPassword(),
                employee.getSex());
    }

    @PutMapping("modify")
    private void modifyEmployee(@RequestBody Employee employee) {
        employeeService.modifyEmployeeById(employee.getEmployeeName(), employee.getEmployeePhone(), employee.getEmployeeAddress(), employee.getEmployeeId());
    }

    @DeleteMapping("remove")
    private void removeEmployee(@RequestParam ("id") Integer id) {
        employeeService.removeEmployeeById(id);
    }


    @GetMapping("/null")
    public String nullPointer(){
        throw new NullPointerException();
    }

    @GetMapping("/runtime")
    public String runtimeException(){
        throw new RuntimeException();
    }

    @GetMapping("/io")
    public String ioException() throws IOException {
        throw new IOException();
    }

    @GetMapping("/sql")
    public String sqlException() throws SQLException {
        throw new SQLException();
    }
}
