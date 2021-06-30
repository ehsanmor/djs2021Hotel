package com.capgemini.hotel.repository;

import com.capgemini.hotel.model.Employee;

import java.util.List;

public interface EmployeeRepository {
    public Employee getEmployeeById(Integer id);
    public List<Employee> getAllEmployees();
    public Employee createEmployee(Employee employee);
    public Employee removeEmployeeById(Integer id);
    public Employee updateEmployeeById(Integer id,Employee employeeParam);
}
