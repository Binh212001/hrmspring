package org.example.springhrm.form;

import lombok.Value;
import org.example.springhrm.dto.EmployeeDto;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link org.example.springhrm.entity.Salary}
 */
@Value
public class SalaryForm implements Serializable {
    Long salaryId;
    Date payDate;
    Double basicSalary;
    Double bonuses;
    Double deductions;
    Double netSalary;
    EmployeeDto employee;
}