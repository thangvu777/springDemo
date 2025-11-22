package com.example.demo.domain.service;

import com.example.demo.domain.repository.EmployeeRepository;
import com.example.demo.domain.vo.EmployeeVO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private static final BigDecimal SALARY_THRESHOLD = new BigDecimal("100000.00");

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     * Returns a list of names for employees earning over a defined salary threshold, sorted in reverse alphabetical order.
     * This method now fetches the employees from the repository.
     *
     * @return A list of employee names, sorted in reverse alphabetical order.
     */
    public List<String> getHighEarningEmployeeNames() {
        return employeeRepository.findAll().stream()
                .filter(employee -> employee.salary().compareTo(SALARY_THRESHOLD) > 0)
                .map(EmployeeVO::name) // .peek(name -> System.out.println("Found high earner: " + name)) // Example of peek for debugging
                .sorted(Comparator.reverseOrder())
                .toList();
    }

    /**
     * Groups high-earning employees by their department.
     *
     * @return A map where the key is the department name and the value is a list of employee names in that department.
     */
    public Map<String, List<String>> getHighEarningEmployeesByDepartment() {
        return employeeRepository.findAll().stream()
                .filter(employee -> employee.salary().compareTo(SALARY_THRESHOLD) > 0)
                .collect(Collectors.groupingBy(
                        EmployeeVO::department, // The classifier function (what to group by)
                        Collectors.mapping(EmployeeVO::name, Collectors.toList()) // A downstream collector to transform the values in each group
                ));
    }
}
