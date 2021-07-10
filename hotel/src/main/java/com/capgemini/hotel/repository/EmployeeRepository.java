package com.capgemini.hotel.repository;

import com.capgemini.hotel.model.Employee;

import java.util.List;

public interface EmployeeRepository {

        public List<Employee> getAllEmployees();

        public Employee createEmployee(Employee employee) throws Exception;

        public Employee getEmployeeById(int id);

        public Employee deleteEmployeeById(int id) throws Exception;

        public Employee updateEmployee(Employee employee) throws Exception;
}
