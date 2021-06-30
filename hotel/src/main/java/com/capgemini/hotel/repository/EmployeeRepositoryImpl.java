package com.capgemini.hotel.repository;

import com.capgemini.hotel.model.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeRepositoryImpl implements EmployeeRepository {

    List<Employee> employees = new ArrayList<>();

    public EmployeeRepositoryImpl(){

        Employee employee =new Employee();
        employee.setId(0);
        employee.setFirstName("Fienke");
        employee.setLastName("Bos");
        employee.setEmail("finekebos@mail");
        employee.setPassword("123");
        employee.setRole("cleaner");
        employee.setTelephoneNumber("+3123444");
        employees.add(employee);

        employees.add(new Employee(1,"esra","tepe","et@mail","","123456","admin"));
        employees.add(new Employee(2,"Linda","tepe","et@mail","","123456","admin"));
    }

    @Override
    public  Employee getEmployeeById(Integer id){
        Employee employee=new Employee();

        for (Employee emp:employees){
            if(emp.getId()==id){
                employee=emp;
                break;
            }else{employee=null;}
        }


        return employee;
    }

    @Override
    public List<Employee> getAllEmployees(){
        return employees;
    }

    @Override
    public Employee createEmployee(Employee employee){
        employee.setId(employees.size());
        employees.add(employee);
        return employee;

    }

    @Override
    public Employee removeEmployeeById(Integer id) {
        Employee employee=new Employee();
        for(Employee emp: employees){
            if(id == emp.getId()){
                employees.remove(emp);
                employee=emp;
                break;
            }

        }

        return employee ;
    }

    @Override
    public Employee updateEmployeeById(Integer id,Employee employeeParam) {
        Employee employee=new Employee();
        for(Employee emp: employees){
            if(id == emp.getId()){
                int index=employees.indexOf(emp);
                employees.set(index,employeeParam);
                employee=emp;
                break;
            }
        }
        return employee ;
    }
}
