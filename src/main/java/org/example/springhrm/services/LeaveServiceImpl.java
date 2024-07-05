package org.example.springhrm.services;

import jakarta.transaction.Transactional;
import org.example.springhrm.entity.*;
import org.example.springhrm.form.LeaveForm;
import org.example.springhrm.repo.AttendanceItemRepository;
import org.example.springhrm.repo.EmployeeRepository;
import org.example.springhrm.repo.LeaveRepository;
import org.example.springhrm.utils.HRMConstant;
import org.example.springhrm.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class LeaveServiceImpl implements LeaveService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    LeaveRepository leaveRepository;
    @Autowired
    AttendanceItemRepository attendanceItemRepository;

    @Override
    public Response save(LeaveForm form) {
        try {
            Optional<Employee> employee = employeeRepository.findById(form.getEmployeeId());
            if (employee.isEmpty()) {
                return new Response("Cannot find employee", false);
            }
            List<Leave> leaveOld = leaveRepository.findByDateAndEmployee(form.getDate(), employee.get());
            if (!leaveOld.isEmpty()) {
                return new Response("Employee already have leave on this day", false);
            }
            Leave leave = form.mapToEty(employee.get());
            leaveRepository.save(leave);
            return new Response("Overtime is created successfully", true);
        } catch (Exception e) {
            return new Response("Create OT fail.", false);
        }
    }

    @Override
    public Response edit(LeaveForm form) {
        Optional<Leave> leave = leaveRepository.findById(form.getLeaveId());
        Optional<Employee> employee = employeeRepository.findById(form.getEmployeeId());
        if (employee.isEmpty()) {
            return new Response("Cannot find employee", false);
        }
        if (leave.isEmpty()) {
            return new Response("Cannot find leave", false);
        }
        leave.get().setReason(form.getReason());
        leave.get().setEmployee(employee.get());
        leave.get().setType(form.getType());
        leave.get().setDate(form.getDate());
        leaveRepository.save(leave.get());
        return new Response("Leave is updated successfully", true);
    }

    @Transactional
    @Override
    public Response approved(List<Long> ids) {
        for (Long id : ids) {
            Optional<Leave> leave = leaveRepository.findById(id);
            leave.get().setStatus(Status.APPROVED);
            LocalDate localDate = leave.get().getDate();
            AttendanceItem attendanceItem = attendanceItemRepository.findByDateAndEmployeeId(localDate, leave.get().getEmployee().getEmployeeId());
            attendanceItem.setWorkingHours(0f);
            attendanceItemRepository.save(attendanceItem);
            leaveRepository.save(leave.get());
        }
        return new Response("Leave Request is approved successfully.", true);
    }

    @Transactional
    @Override
    public Response refused(List<Long> ids) {
        for (Long id : ids) {
            Optional<Leave> leave = leaveRepository.findById(id);
            leave.get().setStatus(Status.REFUSED);
            leaveRepository.save(leave.get());
        }
        return new Response("Leave Request refused successfully.", true);
    }
}
