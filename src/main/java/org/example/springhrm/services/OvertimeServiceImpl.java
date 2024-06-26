package org.example.springhrm.services;

import org.example.springhrm.entity.Employee;
import org.example.springhrm.entity.Overtime;
import org.example.springhrm.form.OvertimeForm;
import org.example.springhrm.repo.EmployeeRepository;
import org.example.springhrm.repo.OvertimeRepository;
import org.example.springhrm.utils.Response;
import org.example.springhrm.utils.TimeConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.Optional;

@Service
public class OvertimeServiceImpl implements OvertimeService {
    @Autowired
    OvertimeRepository overtimeRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Response save(OvertimeForm overtimeForm) {
        try {
            Optional<Employee> employee = employeeRepository.findById(overtimeForm.getEmployeeId());
            if (employee.isEmpty()) {
                return new Response("Cannot find employee", false);
            }
            Overtime overtime = overtimeForm.mapToEty(employee.get());
            overtimeRepository.save(overtime);
            return new Response("Overtime is created successfully", true);
        } catch (Exception e) {
            return new Response("Create OT fail.", false);
        }
    }

    @Override
    public Response edit(OvertimeForm form) {
        try {
            Optional<Overtime> overtime = overtimeRepository.findById(form.getOvertimeId());
            if (overtime.isEmpty()) {
                return new Response("Cannot find overtime", false);
            }
            Optional<Employee> employee = employeeRepository.findById(form.getEmployeeId());
            if (employee.isEmpty()) {
                return new Response("Cannot find employee", false);
            }
            overtime.get().setEmployee(employee.get());
            overtime.get().setDate(form.getDate());
            overtime.get().setReason(form.getReason());
            overtime.get().setReason(form.getReason());
            Time startTimeOt = TimeConvert.StringToTime(form.getStartTime());
            Time endTimeOt =  TimeConvert.StringToTime(form.getEndTime());
            Float durationRealTime = TimeConvert.computeDuration(form.getStartTime(),form.getEndTime());
            overtime.get().setDuration(durationRealTime);
            overtime.get().setStartTime(startTimeOt);
            overtime.get().setEndTime(endTimeOt);
            overtimeRepository.save(overtime.get());
            return new Response("Overtime is updated successfully", true);
        } catch (Exception e) {
            return new Response("Overtime is edited failure.", false);
        }
    }
}
