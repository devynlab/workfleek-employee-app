package io.devynlab.employeeapp.model;

import io.devynlab.employeeapp.enums.Department;
import io.devynlab.employeeapp.enums.Position;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "name")
  private String name;

  @Enumerated(EnumType.STRING)
  @Column(name = "dept")
  private Department dept;

  @Column(name = "employee_number", unique = true)
  private String employeeNumber;

  @Enumerated(EnumType.STRING)
  @Column(name = "position")
  private Position position;
}
