package io.devynlab.employeeapp.service;

import io.devynlab.employeeapp.dto.EmployeeRequest;
import io.devynlab.employeeapp.dto.EmployeeResponse;
import io.devynlab.employeeapp.exception.NotFoundException;
import io.devynlab.employeeapp.model.Employee;
import io.devynlab.employeeapp.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeService {
  private final ModelMapper modelMapper;
  private final EmployeeRepository employeeRepo;

  public EmployeeResponse createEmployee(EmployeeRequest request) {
    Employee employee = modelMapper.map(request, Employee.class);
    employee.setEmployeeNumber(String.valueOf(UUID.randomUUID()));
    Employee savedEmployee = employeeRepo.save(employee);
    return modelMapper.map(savedEmployee, EmployeeResponse.class);
  }

  public Page<EmployeeResponse> findAll(Integer page, Integer size) {
    Pageable pageable = PageRequest.of(page, size);
    Page<Employee> employees = employeeRepo.findAll(pageable);
    return employees.map(employee -> modelMapper.map(employee, EmployeeResponse.class));
  }

  public EmployeeResponse findByEmpNo(String empNo) {
    Employee employee = employeeRepo.findByEmployeeNumber(empNo).orElseThrow(() -> new NotFoundException("Employee not found"));
    return modelMapper.map(employee, EmployeeResponse.class);
  }

  public EmployeeResponse updateEmployee(String employeeId, EmployeeRequest request) {
    Employee employee = employeeRepo.findByEmployeeNumber(employeeId).orElseThrow(() -> new NotFoundException("Employee not found"));
    modelMapper.map(request, employee);
    employeeRepo.save(employee);
    return modelMapper.map(employee, EmployeeResponse.class);
  }

  public void deleteEmployee(String empNo) {
    Employee employee = employeeRepo.findByEmployeeNumber(empNo)
        .orElseThrow(() -> new NotFoundException("Employee not found"));
    employeeRepo.delete(employee);
  }
}
