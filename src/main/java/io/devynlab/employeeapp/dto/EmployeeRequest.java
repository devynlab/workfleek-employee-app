package io.devynlab.employeeapp.dto;

import io.devynlab.employeeapp.enums.Department;
import io.devynlab.employeeapp.enums.Position;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest {
  @NotBlank(message = "Name is required")
  private String name;

  @NotNull(message = "Department is required")
  private Department dept;

  @NotNull(message = "Position is required")
  private Position position;
}
