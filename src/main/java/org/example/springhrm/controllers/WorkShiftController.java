package org.example.springhrm.controllers;


import org.example.springhrm.entity.Attendance;
import org.example.springhrm.entity.Employee;
import org.example.springhrm.form.AttendanceForm;
import org.example.springhrm.form.LeaveForm;
import org.example.springhrm.repo.AttendanceItemRepository;
import org.example.springhrm.repo.AttendanceRepository;
import org.example.springhrm.repo.EmployeeRepository;
import org.example.springhrm.services.ShiftService;
import org.example.springhrm.utils.HRMConstant;
import org.example.springhrm.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = {"/work-shift"})
public class WorkShiftController {
    @Autowired
    AttendanceRepository attendanceRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ShiftService shiftService;
    @Autowired
    AttendanceItemRepository attendanceItemRepository;

    @GetMapping(value = {"/", ""})
    public String home(Model model) {
        List<Attendance> attendances = attendanceRepository.findAll();
        model.addAttribute("attendances", attendances);

        return "shift/shift";
    }

    @GetMapping(value = {"/shift"})
    public String detail(Model model ,@RequestParam("id") Long id ) {
        Optional<Attendance> attendances = attendanceRepository.findById(id);
        model.addAttribute("attendances", attendances.get());
        return "shift/shiftDetail";
    }

    @GetMapping("/create-edit")
    public String create(Model model, @RequestParam("mode") String mode, @RequestParam("id") Long id) {
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees);
        model.addAttribute("mode", mode);
        if (HRMConstant.MODE_CREATE.equals(mode)) {
            return HRMConstant.SHIFT_CREATE_EDIT;
        }
        Optional<Attendance> attendance = attendanceRepository.findById(id);
        model.addAttribute("attendance", attendance.get());
        return HRMConstant.SHIFT_CREATE_EDIT;
    }


    @PostMapping("/save")
    public ResponseEntity<Response> save(@RequestBody AttendanceForm form) {

        Response created = shiftService.save(form);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/edit")
    public ResponseEntity<Response> edit(@RequestBody List<AttendanceForm> form) {
        Response edited = shiftService.edit(form);
        return ResponseEntity.ok(edited);
    }

    @PostMapping("/approved")
    public ResponseEntity<Response> approve(@RequestBody List<Long> ids) {
        Response approved = shiftService.approved(ids);
        return ResponseEntity.ok(approved);
    }

    @PostMapping("/refused")
    public ResponseEntity<Response> refuse(@RequestBody List<Long> ids) {
        Response refused = shiftService.refused(ids);
        return ResponseEntity.ok(refused);
    }
}
