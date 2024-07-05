package org.example.springhrm.services;

import jakarta.transaction.Transactional;
import org.example.springhrm.entity.*;
import org.example.springhrm.form.AttendanceForm;
import org.example.springhrm.repo.AttendanceItemRepository;
import org.example.springhrm.repo.AttendanceRepository;
import org.example.springhrm.repo.EmployeeRepository;
import org.example.springhrm.utils.HRMConstant;
import org.example.springhrm.utils.Response;
import org.example.springhrm.utils.TimeConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ShiftServiceImpl implements ShiftService {
    @Autowired
    AttendanceRepository attendanceRepository;
    @Autowired
    AttendanceItemRepository attendItemRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @Transactional
    @Override
    public Response save(AttendanceForm form) {
        Optional<Employee> employee = employeeRepository.findById(form.getEmployeeId());
        Integer month = TimeConvert.getMonthFromDate(form.getDate());
        Integer year = TimeConvert.getYearFromDate(form.getDate());
        if (employee.isEmpty()) {
            return new Response("Cannot find employee", false);
        }
        List<Attendance> checkAttendance = attendanceRepository.findByEmployeeAndMonthAndYear(employee, month, year);
        if (!checkAttendance.isEmpty()) {
            return new Response("Attendance for this month and year is already exist", false);
        }
        LocalDate currentDate = LocalDate.now();
        List<LocalDate> dateOfAttendance = TimeConvert.getListDate(currentDate);
        List<AttendanceItem> attendanceItemList = new ArrayList<>();
        for (LocalDate date : dateOfAttendance) {
            AttendanceItem attendItem = new AttendanceItem();
            attendItem.setDate(date);
            attendItem.setCheckInTime(TimeConvert.convertToTime("09:00"));
            attendItem.setCheckOutTime(TimeConvert.convertToTime("18:00"));
            if (date.getDayOfWeek().getValue() != 6 && date.getDayOfWeek().getValue() != 7) {
                attendItem.setWorkingHours(8.0f);
            } else {
                attendItem.setWorkingHours(0.0f);
            }
            attendItem.setOvertimeHours(0.0f);
            switch (date.getDayOfWeek().getValue()) {
                case 1:
                    attendItem.setDayOfWeek(HRMConstant.MONDAY);
                    break;
                case 2:
                    attendItem.setDayOfWeek(HRMConstant.TUESDAY);
                    break;
                case 3:
                    attendItem.setDayOfWeek(HRMConstant.WEDNESDAY);
                    break;

                case 4:
                    attendItem.setDayOfWeek(HRMConstant.THURSDAY);
                    break;
                case 5:
                    attendItem.setDayOfWeek(HRMConstant.FRIDAY);
                    break;
                case 6:
                    attendItem.setDayOfWeek(HRMConstant.SATURDAY);
                    break;
                default:
                    attendItem.setDayOfWeek(HRMConstant.SUNDAY);
                    break;
            }
            attendItem.setEmployeeId(employee.get().getEmployeeId());
            AttendanceItem atd = attendItemRepository.save(attendItem);
            attendanceItemList.add(atd);
        }
        Attendance attendance = form.mapToEntity(employee.get(), attendanceItemList);
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
        for (Long id : ids) {
            Optional<Attendance> attendance = attendanceRepository.findById(id);
            attendance.get().setStatus(Status.APPROVED);
            attendanceRepository.save(attendance.get());
        }
        return new Response("Working Shift is approved successfully.", true);
    }

    @Transactional
    @Override
    public Response refused(List<Long> ids) {
        for (Long id : ids) {
            Optional<Attendance> attendance = attendanceRepository.findById(id);
            attendance.get().setStatus(Status.REFUSED);
            attendanceRepository.save(attendance.get());
        }
        return new Response("Attendance was refused successfully.", true);
    }
}
