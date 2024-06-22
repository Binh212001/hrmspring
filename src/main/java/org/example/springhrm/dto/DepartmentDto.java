package org.example.springhrm.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.springhrm.entity.Department}
 */
@Value
public class DepartmentDto implements Serializable {
    Long departmentId;
    String departmentName;
    EmployeeDto manager;
}