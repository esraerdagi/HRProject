package com.example.HR.repository;

import com.example.HR.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Bu anomasyon, bu sınıfın bir Spring veritabanı deposu olduğunu belirtir.
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

// save, update

// JPA -- CRUD işlemleri için gerekli metotları sağlar.