package org.example.springhrm.dto;

import lombok.Value;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link org.example.springhrm.entity.Salary}
 */
@Value
public class SalaryDto implements Serializable {
    Long salaryId;
    Date payDate;
    Double basicSalary;
    Double bonuses;
    Double deductions;
    Double netSalary;
    EmployeeDto employee;
}