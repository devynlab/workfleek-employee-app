package io.devynlab.employeeapp.repository;

import io.devynlab.employeeapp.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends MyBaseRepository<Employee, Integer> {
  Optional<Employee> findByEmployeeNumber(String employeeNumber);
}
