package io.devynlab.employeeapp.controller;

import io.devynlab.employeeapp.dto.EmployeeRequest;
import io.devynlab.employeeapp.dto.EmployeeResponse;
import io.devynlab.employeeapp.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("employees")
public class EmployeeController {
  private final EmployeeService employeeService;

  @PostMapping
  public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody @Valid EmployeeRequest request) {
    return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(request));
  }

  @GetMapping
  public ResponseEntity<Page<EmployeeResponse>> findAll(
      @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
      @RequestParam(name = "size", required = false, defaultValue = "10") Integer size,
      @RequestParam(name = "sortColumn", required = false, defaultValue = "id") String sortColumn,
      @RequestParam(name = "sortOrder", required = false, defaultValue = "asc") String sortOrder) {
    return ResponseEntity.ok(employeeService.findAll(page, size, sortColumn, sortOrder));
  }

  @GetMapping("{empNo}")
  public ResponseEntity<EmployeeResponse> findByEmpNo(@PathVariable("empNo") String empNo) {
    return ResponseEntity.ok(employeeService.findByEmpNo(empNo));
  }

  @PutMapping("{empNo}")
  public ResponseEntity<EmployeeResponse> updateEmployee(@PathVariable("empNo") String empNo, @RequestBody @Valid EmployeeRequest request) {
    return ResponseEntity.ok(employeeService.updateEmployee(empNo, request));
  }

  @DeleteMapping("{empNo}")
  public ResponseEntity<Map<String, Object>> deleteEmployee(@PathVariable("empNo") String empNo) {
    employeeService.deleteEmployee(empNo);
    return ResponseEntity.ok(Map.of("status", HttpStatus.OK, "message", "Employee deleted."));
  }
}
