package org.example.springhrm.services;

import jakarta.transaction.Transactional;
import org.example.springhrm.entity.Attendance;
import org.example.springhrm.entity.Employee;
import org.example.springhrm.form.AttendanceForm;
import org.example.springhrm.repo.AttendanceRepository;
import org.example.springhrm.repo.EmployeeRepository;
import org.example.springhrm.utils.HRMConstant;
import org.example.springhrm.utils.Response;
import org.example.springhrm.utils.TimeConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShiftServiceImpl implements ShiftService {
    @Autowired
    AttendanceRepository attendanceRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Response save(AttendanceForm form) {
        Optional<Employee> employee = employeeRepository.findById(form.getEmployeeId());
        if (employee.isEmpty()) {
            return new Response("Cannot find employee", false);
        }
        Attendance attendance = form.mapToEntity(employee.get());
        attendanceRepository.save(attendance);
        return new Response("Attendance is saved successfully.", true);
    }

    @Transactional
    @Override
    public Response edit(List<AttendanceForm> form) {
        try {
            for (AttendanceForm attendanceForm : form) {
                Optional<Employee> employee = employeeRepository.findById(attendanceForm.getEmployeeId());
                if (employee.isEmpty()) {
                    return new Response("Cannot find employee", false);
                }
                Optional<Attendance> attendance = attendanceRepository.findById(attendanceForm.getAttendanceId());
                if (attendance.isEmpty()) {
                    return new Response("Cannot find attendance", false);
                }
                attendance.get().setAttendanceId(attendanceForm.getAttendanceId());
                attendance.get().setYear(TimeConvert.getYearFromDate(attendanceForm.getDate()));
                attendance.get().setMonth(TimeConvert.getMonthFromDate(attendanceForm.getDate()));
                attendance.get().setEmployee(employee.get());
                attendance.get().setCreatedAt(attendanceForm.getDate());
                attendanceRepository.save(attendance.get());
            }
            return new Response("Attendance is saved successfully.", true);
        } catch (Exception e) {
            return new Response(e.getMessage(), false);
        }
    }

    @Transactional
    @Override
    public Response approved(List<Long> ids) {
        for (Long id : ids){
            Optional<Attendance> attendance = attendanceRepository.findById(id);
            attendance.get().setStatus(HRMConstant.APPROVED);
            attendanceRepository.save(attendance.get());
        }
        return new Response("Working Shift is approved successfully.", true);
    }
}
