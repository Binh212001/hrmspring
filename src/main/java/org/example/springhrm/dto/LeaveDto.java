package org.example.springhrm.dto;

import lombok.Value;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link org.example.springhrm.entity.Leave}
 */
@Value
public class LeaveDto implements Serializable {
    Long leaveId;
    Date startDate;
    Date endDate;
    String type;
    String status;
    String reason;
    EmployeeDto employee;
}