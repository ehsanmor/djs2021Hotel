package com.capgemini.hotel.repository;

import com.capgemini.hotel.model.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeRepositoryImpl implements EmployeeRepository {

    public List<Employee> employees = new ArrayList<>();

    public EmployeeRepositoryImpl(){

        employees.add(new Employee(1, "John", "Jansen", "johnjansen@gmail.com", "password1", "0612312312", "manager"));
        employees.add(new Employee(2, "Maria", "Brode", "mariabrode@gmail.com", "password2", "0622312312", "receptionist"));
        employees.add(new Employee(3, "Anca", "Morris", "ancamorris@gmail.com", "password3", "0632312312", "receptionist"));
        employees.add(new Employee(4, "Astrid", "Marta", "astridmarta@gmail.com", "password4", "0642312312", "cleaner"));
        employees.add(new Employee(5, "Misti", "Brok", "mistibrok@gmail.com", "password5", "0652312312", "cleaner"));
    }

    @Override
    public List<Employee> getAllEmployees() {

        return employees;
    }

    @Override
    public Employee createEmployee(Employee employee) throws Exception {

        for (Employee employeeToFind : employees) {
            if (employeeToFind.getId() == employee.getId()) {
                throw new Exception("Employee is exist!");
            }
        }

        employees.add(employee);

        return employee;
    }

    @Override
    public Employee getEmployeeById(int id) {

        for (Employee employee: employees) {

            if(employee.getId() == id){
                return  employee;
            }
        }

        return null;
    }

    @Override
    public Employee deleteEmployeeById(int id) throws Exception {

        Employee employeeToBeRemoved = getEmployeeById(id);

        if(employeeToBeRemoved == null){
            throw new Exception("Employee is not exist!");
        }

        employees.remove(employeeToBeRemoved);

        return employeeToBeRemoved;
    }

    @Override
    public Employee updateEmployee(Employee employee) throws Exception {

        Employee employeeToBeUpdated = getEmployeeById(employee.getId());

        if(employeeToBeUpdated == null){
            throw new Exception("Employee is not exist!");
        }

        employeeToBeUpdated.setEmail(employee.getEmail());
        employeeToBeUpdated.setPassword(employee.getPassword());
        employeeToBeUpdated.setFirstName(employee.getFirstName());
        employeeToBeUpdated.setLastName(employee.getLastName());
        employeeToBeUpdated.setTelephoneNumber(employee.getTelephoneNumber());
        employeeToBeUpdated.setRole(employee.getRole());

        return employeeToBeUpdated;
    }
}
