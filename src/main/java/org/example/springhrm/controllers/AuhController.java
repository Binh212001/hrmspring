package org.example.springhrm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuhController {
    @RequestMapping("/login")
    public String login() {
        return "auth/auth";
    }
}
