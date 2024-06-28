package com.example.HR.controller;

import com.example.HR.model.Employee;
import com.example.HR.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Bu anatasyon, bu sınıfın bir control sınıfı olduğunu belirtir.
@RequestMapping("/api/employees") // Temel url adresi
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/hire")//Bu anotasyon ile işaretlenen bu metot, bir çalışanı işe almak için kullanılır.
    @Operation(summary = "Yeni personel kaydı yapar.")
    public Employee hireEmployee(@RequestBody Employee employee) {
        return employeeService.hireEmployee(employee);
    }

    @GetMapping()// çalışanları getirmek için service sınıfından oluşturduğumuz "getAllEmployees" metodu çağırarak döndürüyoruz.
    @Operation(summary = "Tüm personelleri getirip listeler.")
    public List<Employee> getAllEmployees(){
        return employeeService.getEmployeesAll();
    }
    @GetMapping("/{id}")
    @Operation(summary = "Belirli bir personeli ID numarasına göre getirir.")
    public Optional<Employee>getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }
    @PutMapping("/{id}")
    @Operation(summary = "Bir personelin bilgilerini günceller.")
    public Employee updateEmployee(@PathVariable Long id,@RequestBody Employee employeeDetails){
        return employeeService.updateEmployee(id,employeeDetails);
    }
    @DeleteMapping("/fire/{id}")
    @Operation(summary = "(Bir personeli siler.)")
    public void fireEmployee(@PathVariable Long id){
        employeeService.fireEmployee(id);
    }



}

// config= configuration = ayarlamak