package com.capgemini.hotel.service;

import com.capgemini.hotel.model.Employee;
import com.capgemini.hotel.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;

    public EmployeeServiceImpl() {
    }

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {

        List<Employee> employees = employeeRepository.getAllEmployees();

        return employees;
    }

    @Override
    public Employee createEmployee(Employee employee) {

        Employee createdEmployee = null;
        try {
            createdEmployee = employeeRepository.createEmployee(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return createdEmployee;
    }

    @Override
    public Employee getEmployeeById(int id) {

        Employee employee = employeeRepository.getEmployeeById(id);

        return employee;
    }

    @Override
    public Employee deleteEmployeeById(int id) {

        Employee deletedEmployee = null;
        try {
            deletedEmployee = employeeRepository.deleteEmployeeById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return deletedEmployee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {

        Employee updatedEmployee = null;
        try {
            updatedEmployee = employeeRepository.updateEmployee(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return updatedEmployee;
    }
}
