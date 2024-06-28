package com.example.HR.service;

import com.example.HR.model.Employee;
import com.example.HR.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired// new lemeğin yerine kullanılıyor.
    private EmployeeRepository employeeRepository;

    public Employee hireEmployee(Employee employee){ // Create
        return employeeRepository.save(employee);
    }

    public List<Employee> getEmployeesAll(){ //Read
        return employeeRepository.findAll(); //Tüm çalışanları veri tabanından findall metodu ile getirir.
    }
    public Optional<Employee> getEmployeeById(Long id){
        // belirtilen kimlikteki çalışsanı veritabanından getirir.
        return employeeRepository.findById(id);
    }
    public Employee updateEmployee(Long id, Employee employeeDetails){//Update
        Employee employee = employeeRepository.findById(id).
                orElseThrow(()->new RuntimeException("Çalışan bulunamadı"));// yani if else demek. Splitte böyle yazılıyor.
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setPosition(employeeDetails.getPosition());
        return employeeRepository.save(employee);
    }
    public void fireEmployee(Long id){//Delete
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Employee not found"));

        employeeRepository.delete(employee);

    }
}


