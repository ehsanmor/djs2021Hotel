package com.capgemini.hotel.service;

import com.capgemini.hotel.model.Employee;
import io.swagger.models.auth.In;

import java.util.List;

public interface EmployeeService {
    public Employee getEmployeeById(Integer id);
    public List<Employee> getAllEmployees();
    public Employee createEmployee(Employee employee);
    public Employee removeEmployeeById(Integer id);
    public Employee updateEmployeeById(Integer id,Employee employee);

}
