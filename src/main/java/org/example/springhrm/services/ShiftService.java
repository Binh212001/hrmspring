package org.example.springhrm.services;

import org.example.springhrm.form.AttendanceForm;
import org.example.springhrm.form.LeaveForm;
import org.example.springhrm.utils.Response;

import java.util.List;

public interface ShiftService {
    Response save(AttendanceForm form);

    Response edit(List<AttendanceForm> form);
}
