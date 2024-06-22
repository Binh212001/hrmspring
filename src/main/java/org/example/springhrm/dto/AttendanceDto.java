package org.example.springhrm.dto;

import lombok.Value;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link org.example.springhrm.entity.Attendance}
 */
@Value
public class AttendanceDto implements Serializable {
    Long attendanceId;
    Date date;
    Date checkInTime;
    Date checkOutTime;
    Integer workingHours;
    Integer overtimeHours;
    String status;
    EmployeeDto employee;
}