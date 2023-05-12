package io.devynlab.employeeapp.repository;

import io.devynlab.employeeapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
  Optional<Employee> findByEmployeeNumber(String employeeNumber);
}
