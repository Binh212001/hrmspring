package org.example.springhrm.form;

import lombok.Value;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link org.example.springhrm.entity.Overtime}
 */
@Value
public class OvertimeForm implements Serializable {
    Long overtimeId;
    Date date;
    Integer hours;
    String reason;
    EmployeeForm employee;
}