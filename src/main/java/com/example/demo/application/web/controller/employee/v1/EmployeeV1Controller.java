package com.example.demo.application.web.controller.employee.v1;

import com.example.demo.domain.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * REST controller for handling employee-related API requests.
 * @RestController combines @Controller and @ResponseBody, which serializes return objects into JSON.
 */
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeV1Controller {

    private final EmployeeService employeeService;

    // Using constructor injection to get the EmployeeService bean.
    public EmployeeV1Controller(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/high-earners")
    public List<String> getHighEarningEmployees() {
        return employeeService.getHighEarningEmployeeNames();
    }

    @GetMapping("/high-earners-by-department")
    public Map<String, List<String>> getHighEarningEmployeesByDepartment() {
        return employeeService.getHighEarningEmployeesByDepartment();
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<String> checkEmployeeId(@PathVariable Integer employeeId){
                String result = employeeService.verifyEmployeeId(employeeId);
                return result != null ? ResponseEntity.ok(result) : ResponseEntity.notFound().build();
    }

}
