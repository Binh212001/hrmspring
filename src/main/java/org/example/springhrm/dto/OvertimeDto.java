package org.example.springhrm.dto;

import lombok.Value;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

/**
 * DTO for {@link org.example.springhrm.entity.Overtime}
 */
@Value
public class OvertimeDto implements Serializable {
    Long overtimeId;
    Date date;
    Integer hours;
    String reason;
    private Time startTime;
    private  Time endTime;
    EmployeeDto employee;
}