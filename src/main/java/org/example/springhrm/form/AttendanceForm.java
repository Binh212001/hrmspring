package org.example.springhrm.form;

import lombok.Value;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link org.example.springhrm.entity.Attendance}
 */
@Value
public class AttendanceForm implements Serializable {
    Long attendanceId;
    Date date;
    Date checkInTime;
    Date checkOutTime;
    Integer workingHours;
    Integer overtimeHours;
    String status;
    EmployeeForm employee;
}