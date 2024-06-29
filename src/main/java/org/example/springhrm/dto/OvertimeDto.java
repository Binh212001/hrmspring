package org.example.springhrm.dto;

import lombok.Value;

import java.io.Serializable;
import java.util.Date;
import java.util.Timer;

/**
 * DTO for {@link org.example.springhrm.entity.Overtime}
 */
@Value
public class OvertimeDto implements Serializable {
    Long overtimeId;
    Date date;
    Integer hours;
    String reason;
    private Timer startTime;
    private  Timer endTime;
    EmployeeDto employee;
}