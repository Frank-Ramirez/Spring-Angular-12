package com.frank.Employeemanager.servicie;

import com.frank.Employeemanager.exception.UserNotFoundException;
import com.frank.Employeemanager.model.Employee;
import com.frank.Employeemanager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employRepo;
    @Autowired
    public EmployeeService (EmployeeRepo employRepo){
        this.employRepo = employRepo;
    }
    public Employee AddEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employRepo.save(employee);
    }
    public List<Employee> findAllEmployee (){
        return employRepo.findAll();
    }
    public Employee updateEmployee (Employee employee){
        return employRepo.save(employee);
    }
    public Employee findEmployee (Long id){
        //se crea una excepcion " UserNotFoundException" cuando no exista el usuario en la bd o en la aplicacion
        return employRepo.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("Usuario con id "+id+" was not found"));
    }
    public void deleteEmployee (Long id){
         employRepo.deleteEmployeeById(id);
    }
}
