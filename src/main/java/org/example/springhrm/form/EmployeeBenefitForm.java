package org.example.springhrm.form;

import lombok.Value;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link org.example.springhrm.entity.EmployeeBenefit}
 */
@Value
public class EmployeeBenefitForm implements Serializable {
    Long employeeBenefitId;
    Date startDate;
    Date endDate;
    EmployeeForm employee;
    BenefitForm benefit;
}