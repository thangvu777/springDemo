package com.example.demo.domain.repository;

import com.example.demo.domain.vo.EmployeeVO;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * In a real application, this would be a Spring Data JPA interface
 * extending JpaRepository<Employee, Long> to fetch data from a database.
 * For this demo, it's a component that returns a hardcoded list.
 */
@Repository
public class EmployeeRepository {

    private List<Integer> employeeIds = new ArrayList<>(List.of(50,2,12,3));

    public List<EmployeeVO> findAll() {
        // This simulates fetching all employees from a database.
        return List.of(
                new EmployeeVO("Thang Vu", new BigDecimal("120000.00"), "FI"),
                new EmployeeVO("Chris Lee", new BigDecimal("125000.00"), "WI"),
                new EmployeeVO("Trey Smith", new BigDecimal("150000.00"), "FI LABS"),
                new EmployeeVO("Jane Doe", new BigDecimal("95000.00"), "HR")
        );
    }

    public String findById(Integer id){
        return employeeIds.contains(id)? String.format("Employee Id Found: %d", id) : null;
    }
}