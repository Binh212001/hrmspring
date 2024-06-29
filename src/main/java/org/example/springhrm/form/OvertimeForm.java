package org.example.springhrm.form;

import lombok.Value;
import org.example.springhrm.entity.Employee;
import org.example.springhrm.entity.Overtime;

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
        String[] startTimeList = startTime.split(":");
        String[] endTimeList = endTime.split(":");
        Time startTimeOt = new Time(Integer.parseInt(startTimeList[0]), Integer.parseInt(startTimeList[1]), 0);
        Time endTimeOt = new Time(Integer.parseInt(endTimeList[0]), Integer.parseInt(endTimeList[1]), 0);
        overtime.setStartTime(startTimeOt);
        overtime.setEndTime(endTimeOt);
        Integer hours = Math.abs(Integer.parseInt(endTimeList[0]) - Integer.parseInt(startTimeList[0]));
        Integer minutes = Math.abs(Integer.parseInt(endTimeList[1]) - Integer.parseInt(startTimeList[1]));
        Float durationRealTime = Float.valueOf(hours + (float) minutes / 60);
        overtime.setDuration(durationRealTime);
        overtime.setEmployee(employee);
        return overtime;
    }
}