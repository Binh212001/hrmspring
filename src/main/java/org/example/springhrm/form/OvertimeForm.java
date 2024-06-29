package org.example.springhrm.form;

import lombok.Value;
import org.example.springhrm.entity.Employee;
import org.example.springhrm.entity.Overtime;
import org.example.springhrm.utils.TimeConvert;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Timer;

/**
 * DTO for {@link org.example.springhrm.entity.Overtime}
 */
@Value
public class OvertimeForm implements Serializable {
    private Long overtimeId;
    private Date date;
    private String reason;
    private String startTime;
    private String endTime;
    private long employeeId;

    public Overtime mapToEty(Employee employee) {
        Overtime overtime = new Overtime();
        overtime.setDate(date);
        overtime.setReason(reason);
        Time startTimeOt = TimeConvert.StringToTime(startTime);
        Time endTimeOt =  TimeConvert.StringToTime(endTime);
        overtime.setStartTime(startTimeOt);
        overtime.setEndTime(endTimeOt);
        Float durationRealTime = TimeConvert.computeDuration(startTime,endTime);
        overtime.setDuration(durationRealTime);
        overtime.setEmployee(employee);
        return overtime;
    }
}