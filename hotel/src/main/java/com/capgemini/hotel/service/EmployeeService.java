package com.capgemini.hotel.service;

import com.capgemini.hotel.model.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees();

    public Employee createEmployee(Employee employee);

    public Employee getEmployeeById(int id);

    public Employee deleteEmployeeById(int id);

    public Employee updateEmployee(Employee employee);
}
