package com.lekwacious.employee_app.web;

import com.lekwacious.employee_app.data.models.Employee;
import com.lekwacious.employee_app.data.payloads.MessageResponse;
import com.lekwacious.employee_app.data.payloads.request.EmployeeRequest;
import com.lekwacious.employee_app.data.repository.EmployeeRepository;
import com.lekwacious.employee_app.exception.ResourceNotFoundException;
import com.lekwacious.employee_app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.util.Elements;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@RestController
@RequestMapping("/api/v1")


public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @CrossOrigin(origins = "*")
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> footballers = employeeService.getAllEmployee();
        return new ResponseEntity<>(footballers, HttpStatus.OK);
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/employees")
    public ResponseEntity<MessageResponse> addEmployee(@RequestBody EmployeeRequest employee) {
        MessageResponse newEmployee = employeeService.createEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id) {
        Employee employee = employeeService.getASingleEmployee(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    @CrossOrigin(origins = "*")
    @PutMapping("/employees/{id}")
    public Optional<Employee> updateEmployee(@PathVariable Integer id, @RequestBody EmployeeRequest employee) {
        return employeeService.updateEmployee(id, employee);

    }
    @CrossOrigin(origins = "*")
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Integer id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


