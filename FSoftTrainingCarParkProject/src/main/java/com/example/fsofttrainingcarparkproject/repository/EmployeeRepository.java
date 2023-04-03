package com.example.fsofttrainingcarparkproject.repository;

import com.example.fsofttrainingcarparkproject.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * TODO: Để ý thấy Tuấn không dùng @Repository ở đây mà lại chỉ dùng @Transactional → tìm hiểu xem tại sao?
 */

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "SELECT * FROM Employee", nativeQuery = true)
    Page<Employee> findAllEmployee(Pageable pageable);

    /*@Query(value = "SELECT * FROM  Employee e WHERE e.employee_id = ?1", nativeQuery = true)
    Page<Employee> findEmployeeById(Integer id, Pageable pageable);*/

    @Query(value = "SELECT * FROM  Employee e WHERE e.employee_id = ?1", nativeQuery = true)
    Optional<Employee> findEmployeeById(Integer id);

    @Query(value = "SELECT * FROM  Employee e WHERE e.employee_name LIKE lower (CONCAT('%', ?1, '%'))", nativeQuery = true)
    Page<Employee> findEmployeeByName(String name, Pageable pageable);

    @Modifying
    @Query(value = "INSERT INTO Employee (" +
            "employee_id, " +
            "account, " +
            "department, " +
            "employee_address, " +
            "employee_birthday, " +
            "employee_email, " +
            "employee_name, " +
            "employee_phone, " +
            "password, " +
            "sex) VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10)", nativeQuery = true)
    void saveEmployee(Integer id, String account, String department, String address, Date birthday, String email, String name, String phone, String password, String sex);

    @Modifying
    @Query(value = "DELETE FROM Employee e WHERE e.employee_id = :EmId", nativeQuery = true)
    void deleteEmployeeById(Integer EmId);

    @Modifying
    @Query(value = "UPDATE Employee SET employee_name = ?1, employee_phone = ?2, employee_address = ?3 WHERE employee_id = ?4", nativeQuery = true)
    void updateEmployeeById(String name, String phone, String address, Integer id);


}
