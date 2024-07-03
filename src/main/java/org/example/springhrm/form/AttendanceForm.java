package org.example.springhrm.form;

import lombok.Value;
import org.example.springhrm.entity.Attendance;
import org.example.springhrm.entity.Employee;
import org.example.springhrm.utils.TimeConvert;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link org.example.springhrm.entity.Attendance}
 */
@Value
public class AttendanceForm implements Serializable {
    Long attendanceId;
    Date date;
    Long employeeId;
    String status;

    public Attendance mapToEntity(Employee employee) {
        Attendance attend = new Attendance();

        attend.setAttendanceId(attendanceId);
        attend.setYear(TimeConvert.getYearFromDate(date));
        attend.setMonth(TimeConvert.getMonthFromDate(date));
        attend.setEmployee(employee);
        attend.setStatus(status);
        attend.setCreatedAt(date);
        return attend;
    }
}