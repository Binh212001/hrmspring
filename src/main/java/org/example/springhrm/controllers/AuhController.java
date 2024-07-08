package org.example.springhrm.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class AuhController {
    @RequestMapping("/login")
    public String login(HttpServletRequest request, Model model) {
        return "auth/auth";
    }
}
