package org.example.springhrm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/order"})
public class OrderController {
    @GetMapping(value = {"/" , ""})
    public String home() {
        return "order/order";
    }
}
