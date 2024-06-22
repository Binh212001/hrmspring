package org.example.springhrm.form;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.springhrm.entity.Department}
 */
@Value
public class DepartmentForm implements Serializable {
    Long departmentId;
    String departmentName;
    EmployeeForm manager;
}