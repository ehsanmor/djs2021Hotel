package com.capgemini.hotel.controller;

import com.capgemini.hotel.model.Employee;
import com.capgemini.hotel.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class EmployeeController {

    EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/employees", produces = "application/json")
    public ResponseEntity<List<Employee>> getEmployees() {

        List<Employee> employees = employeeService.getAllEmployees();

        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping(value = "/employee/{id}", produces = "application/json")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(name = "id", required = true) int id){

        Employee employee = employeeService.getEmployeeById(id);

        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @DeleteMapping(value = "/employee/{id}", produces = "application/json")
    public ResponseEntity<Employee> deleteEmployeeById(@PathVariable(name = "id", required = true) int id){

        Employee deletedEmployee = employeeService.deleteEmployeeById(id);

        return new ResponseEntity<Employee>(deletedEmployee, HttpStatus.OK);
    }

    @PostMapping(value = "/employee", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {

        Employee createdEmployee = employeeService.createEmployee(employee);

        return new ResponseEntity<Employee>(createdEmployee, HttpStatus.OK);
    }

    @PutMapping(value = "/employee", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {

        Employee updatedEmployee = employeeService.updateEmployee(employee);

        return new ResponseEntity<Employee>(updatedEmployee, HttpStatus.OK);
    }
}

