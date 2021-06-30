package com.capgemini.hotel.controller;

import com.capgemini.hotel.model.Employee;
import com.capgemini.hotel.service.EmployeeService;
import com.google.inject.spi.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
@Autowired
    EmployeeService employeeService;

    public EmployeeController() {
    }

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/employee/{id}", produces = "application/json")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(name = "id", required = true) Integer id) {
        Employee employee = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);


    }



    @GetMapping(value= "/employees", produces= "application/json")
    public ResponseEntity<List<Employee>> getAllEmployees(){

        List<Employee> employees = employeeService.getAllEmployees();

        return new ResponseEntity<>( employees, HttpStatus.OK);

    }

    @PutMapping(value = "/employee", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        employee = employeeService.createEmployee(employee);

        return new ResponseEntity<>(employee, HttpStatus.OK);

    }

    @DeleteMapping(value= "/remove/{id}", produces= "application/json")
    public ResponseEntity<Message> removeEmployeeById(@PathVariable(name="id", required = true) Integer id){

        employeeService.removeEmployeeById(id);

        return new ResponseEntity<>( new Message("Employee is deleted"), HttpStatus.OK);

    }

//    update fonksiyonu gelecek

//    @PutMapping(value = "/update", produces = "application/json", consumes = "application/json")
//    public ResponseEntity<Employee> updateEmployee(@RequestBody int id,@RequestBody Employee employee) {
//        employee = employeeService.updateEmployeeById(id, employee);
//
//        return new ResponseEntity<>(employee, HttpStatus.OK);
//
//    }
@RequestMapping(method = RequestMethod.PUT,value="/employee/{id}")
public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee,@PathVariable String id) {
        int idInt=Integer.parseInt( id);
    employee = employeeService.updateEmployeeById(idInt, employee);

    return new ResponseEntity<>(employee, HttpStatus.OK);

}
}
