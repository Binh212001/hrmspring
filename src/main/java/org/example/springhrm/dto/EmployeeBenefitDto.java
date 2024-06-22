package org.example.springhrm.dto;

import lombok.Value;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link org.example.springhrm.entity.EmployeeBenefit}
 */
@Value
public class EmployeeBenefitDto implements Serializable {
    Long employeeBenefitId;
    Date startDate;
    Date endDate;
    EmployeeDto employee;
    BenefitDto benefit;
}