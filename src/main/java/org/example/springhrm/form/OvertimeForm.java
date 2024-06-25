package org.example.springhrm.form;

import lombok.Value;
import org.example.springhrm.entity.Employee;
import org.example.springhrm.entity.Overtime;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

/**
 * DTO for {@link org.example.springhrm.entity.Overtime}
 */
@Value
public class OvertimeForm implements Serializable {
    private Long overtimeId;
    private Date date;
    private String reason;
    private Time startTime;
    private Time endTime;
    private long employeeId;

    public Overtime mapToEty(Employee employee) {
        Overtime overtime = new Overtime();
        overtime.setDate(date);
        overtime.setReason(reason);
        overtime.setStartTime(startTime);
        overtime.setEndTime(endTime);
        overtime.setDuration(endTime.getHours() + endTime.getMinutes() / 60 - startTime.getHours() + startTime.getMinutes() / 60);
        overtime.setEmployee(employee);
        return overtime;
    }
}