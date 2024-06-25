package org.example.springhrm.controllers;

import org.example.springhrm.entity.Employee;
import org.example.springhrm.entity.Overtime;
import org.example.springhrm.form.OvertimeForm;
import org.example.springhrm.repo.EmployeeRepository;
import org.example.springhrm.repo.OvertimeRepository;
import org.example.springhrm.services.EmployeeService;
import org.example.springhrm.services.OvertimeService;
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
@RequestMapping(value = {"/overtime"})
public class OvertimeController {
    @Autowired
    OvertimeRepository overtimeRepository;
    @Autowired
    OvertimeService overtimeService;
    @Autowired
    EmployeeService employeeService;

    @GetMapping(value = {"/", ""})
    public String home() {
        return "overtime/overtime";
    }

    @GetMapping(value = {"/create-edit", "/create-edit/"})
    public String createOrEdit(@RequestParam("mode") String mode, Model model, @RequestParam("id") Long id) {
        model.addAttribute("mode", mode);
        if (HRMConstant.MODE_CREATE.equals(mode)) {
            return HRMConstant.OT_CREATE_EDIT;
        }
        Optional<Overtime> overtime = overtimeRepository.findById(id);
        if (overtime.isEmpty()) {
            return HRMConstant.OT_LIST;
        }
        List<Employee> emps =  employeeService.findEmpByLevel();
        model.addAttribute("overtime", overtime.get());
        return HRMConstant.OT_CREATE_EDIT;
    }

    @PostMapping("/save")
    public ResponseEntity<Response> save(@RequestBody OvertimeForm form) {
        Response created = overtimeService.save(form);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/edit")
    public ResponseEntity<Response> edit(@RequestBody OvertimeForm form) {
        Response edited = overtimeService.edit(form);
        return ResponseEntity.ok(edited);
    }
}
