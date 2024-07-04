package org.example.springhrm.controllers;

import org.example.springhrm.entity.Department;
import org.example.springhrm.entity.Employee;
import org.example.springhrm.entity.Position;
import org.example.springhrm.form.EmployeeForm;
import org.example.springhrm.repo.DepartmentRepository;
import org.example.springhrm.repo.EmployeeRepository;
import org.example.springhrm.repo.PositionRepository;
import org.example.springhrm.services.EmployeeService;
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
@RequestMapping(value = {"/employee"})
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    PositionRepository positionRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    @GetMapping(value = {"/", ""})
    public String home(Model model) {
        model.addAttribute("newEmployee", HRMConstant.NEW_EMP);
        return "employee/employee";
    }

    @GetMapping("/create-edit")
    public String create(Model model, @RequestParam("mode") String mode, @RequestParam("id") Long id) {
        List<Position> positions = positionRepository.findAll();
        List<Department> departments = departmentRepository.findAll();
        model.addAttribute("departments" , departments);
        model.addAttribute("positions" , positions);
        if (HRMConstant.MODE_CREATE.equals(mode)) {
            model.addAttribute("mode", mode);
            return HRMConstant.EMP_EDIT_UPDATE_SHOW;
        }
        Optional<Employee> employee = employeeRepository.findById(id);
        if (!employee.isEmpty() && HRMConstant.MODE_EIDiT.equals(mode)) {
            model.addAttribute("employee", employee.get());
            model.addAttribute("mode", mode);
            return HRMConstant.EMP_EDIT_UPDATE_SHOW;
        }
        if (!employee.isEmpty() && HRMConstant.MODE_SHOW.equals(mode)) {
            model.addAttribute("employee", employee.get());
            model.addAttribute("mode", mode);
            return HRMConstant.EMP_EDIT_UPDATE_SHOW;
        }
        return HRMConstant.EMP_LIST;
    }

    @PostMapping("/save")
    public ResponseEntity<Response> save(@RequestBody EmployeeForm employeeForm) {
        Response created = employeeService.save(employeeForm);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/edit")
    public ResponseEntity<Response> edit(@RequestBody EmployeeForm employeeForm) {
        Response edited = employeeService.edit(employeeForm);
        return ResponseEntity.ok(edited);
    }
}
