package org.example.springhrm.dto;

import lombok.Value;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link org.example.springhrm.entity.Contract}
 */
@Value
public class ContractDto implements Serializable {
    Long contractId;
    String contractType;
    Date startDate;
    Date endDate;
    String details;
    EmployeeDto employee;
}