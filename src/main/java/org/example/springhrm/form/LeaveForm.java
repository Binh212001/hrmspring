package org.example.springhrm.form;

import lombok.Value;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link org.example.springhrm.entity.Leave}
 */
@Value
public class LeaveForm implements Serializable {
    Long leaveId;
    Date startDate;
    Date endDate;
    String type;
    String status;
    String reason;
    EmployeeForm employee;
}