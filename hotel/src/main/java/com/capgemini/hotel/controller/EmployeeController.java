package com.capgemini.hotel.controller;

import com.capgemini.hotel.model.Employee;
import com.capgemini.hotel.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
@Autowired
    EmployeeService employeeService;

    public EmployeeController() {
    }

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(name = "id", required = true) Integer id) {
        Employee employee = employeeService.getEmployeeById(id);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);


    }


     @GetMapping(value= "/employees", produces= "application/json")
    public ResponseEntity<List<Employee>> getAllEmployees(){

        List<Employee> employees = employeeService.getAllEmployees();

        return new ResponseEntity<List<Employee>>( employees, HttpStatus.OK);

    }

    @PutMapping(value = "/newemployee", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        employee = employeeService.createEmployee(employee);

        return new ResponseEntity<Employee>(employee, HttpStatus.OK);

    }

    @DeleteMapping(value= "/remove/{id}", produces= "application/json")
    public ResponseEntity<Employee> removeEmployeeById(@PathVariable(name="id", required = true) Integer id){
        Employee employee;
        employee=employeeService.removeEmployeeById(id);

        return new ResponseEntity<Employee>( employee, HttpStatus.OK);

    }


@PutMapping(value="/update/{id}",produces = "application/json")
public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee,@PathVariable (name="id",required = true) Integer id) {
    employee = employeeService.updateEmployeeById(id, employee);

    return new ResponseEntity<Employee>(employee, HttpStatus.OK);

}
}
