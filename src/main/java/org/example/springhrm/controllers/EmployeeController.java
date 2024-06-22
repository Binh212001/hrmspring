package org.example.springhrm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/employee"})
public class EmployeeController {
    @GetMapping(value = {"/" , ""})
    public String home() {
        return "employee/employee";
    }

    @GetMapping("/create")
    public String create() {
        return "employee/create";
    }
}
