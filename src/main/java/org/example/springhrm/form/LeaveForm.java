package org.example.springhrm.form;

import lombok.Value;
import org.example.springhrm.entity.Employee;
import org.example.springhrm.entity.Leave;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * DTO for {@link org.example.springhrm.entity.Leave}
 */
@Value
public class LeaveForm implements Serializable {
    Long leaveId;
    Long employeeId;
    String type;
    String status;
    String reason;
    LocalDate date;
    public Leave mapToEty(Employee employee) {
        Leave leave = new Leave();
        leave.setEmployee(employee);
        leave.setDate(date);
        leave.setReason(reason);
        leave.setType(type);
        return leave;
    }
}