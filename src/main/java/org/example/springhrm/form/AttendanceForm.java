package org.example.springhrm.form;

import lombok.Value;
import org.example.springhrm.entity.Attendance;
import org.example.springhrm.entity.AttendanceItem;
import org.example.springhrm.entity.Employee;
import org.example.springhrm.entity.Status;
import org.example.springhrm.utils.TimeConvert;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * DTO for {@link org.example.springhrm.entity.Attendance}
 */
@Value
public class AttendanceForm implements Serializable {
    Long attendanceId;
    Date date;
    Long employeeId;
    String status;

    public Attendance mapToEntity(Employee employee, List<AttendanceItem> attendanceItemList) {
        Attendance attend = new Attendance();
        attend.setAttendanceId(attendanceId);
        attend.setYear(TimeConvert.getYearFromDate(date));
        attend.setMonth(TimeConvert.getMonthFromDate(date));
        attend.setEmployee(employee);
        attend.setStatus(Status.DRAFT);
        attend.setCreatedAt(date);
        attend.setAttendanceItems(attendanceItemList);
        return attend;
    }
}