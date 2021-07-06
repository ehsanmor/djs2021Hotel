package com.capgemini.hotel.service;

import com.capgemini.hotel.model.Employee;
import com.capgemini.hotel.repository.EmployeeRepository;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(){}

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){this.employeeRepository=employeeRepository;}


    @Override
    public Employee getEmployeeById(Integer id) {

        Employee employee = employeeRepository.getEmployeeById( id);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees(){
        List<Employee> employees=employeeRepository.getAllEmployees();
        return employees;
    }

    @Override
    public Employee createEmployee(Employee employee){
        employee=employeeRepository.createEmployee(employee);
        return employee;
    }

    @Override
    public Employee removeEmployeeById(Integer id){
        Employee employee=employeeRepository.removeEmployeeById( id);
        return employee;
    }
    @Override
    public Employee updateEmployeeById(Integer id,Employee employeeParam){
        Employee employee=employeeRepository.updateEmployeeById(id,employeeParam);
    return employee;
    }
}
