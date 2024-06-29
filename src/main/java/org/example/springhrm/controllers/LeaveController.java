package org.example.springhrm.controllers;

import org.example.springhrm.entity.Employee;
import org.example.springhrm.entity.Leave;
import org.example.springhrm.entity.Overtime;
import org.example.springhrm.form.LeaveForm;
import org.example.springhrm.form.OvertimeForm;
import org.example.springhrm.repo.LeaveRepository;
import org.example.springhrm.services.EmployeeService;
import org.example.springhrm.services.LeaveService;
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
@RequestMapping(value = {"/leave"})
public class LeaveController {
    @Autowired
    LeaveRepository leaveRepository;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    LeaveService leaveService;
    @GetMapping(value = {"/" , ""})
    public String home() {
        return "leave/leave";
    }


    @GetMapping(value = {"/create-edit"})
    public String createOrEdit(@RequestParam("mode") String mode, Model model, @RequestParam("id") Long id) {
        List<Employee> employees =  employeeService.findEmpByLevel();
        model.addAttribute("mode", mode);
        model.addAttribute("employee", employees);
        //mode == 0 create
        if (HRMConstant.MODE_CREATE.equals(mode)) {
            return HRMConstant.LEAVE_CREATE_EDIT;
        }
        //mode != 0 edit .
        //Check not has employee , redirect to list view
        Optional<Leave> leave = leaveRepository.findById(id);
        if (leave.isEmpty()) {
            return HRMConstant.LEAVE_LIST;
        }
        model.addAttribute("leave", leave.get());
        return HRMConstant.LEAVE_CREATE_EDIT;
    }

    @PostMapping("/save")
    public ResponseEntity<Response> save(@RequestBody LeaveForm form) {
        Response created = leaveService.save(form);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/edit")
    public ResponseEntity<Response> edit(@RequestBody LeaveForm form) {
        Response edited = leaveService.edit(form);
        return ResponseEntity.ok(edited);
    }
}
