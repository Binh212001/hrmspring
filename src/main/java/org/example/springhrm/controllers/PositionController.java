package org.example.springhrm.controllers;

import org.example.springhrm.repo.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/position")
public class PositionController {
    @Autowired
    PositionRepository positionRepository;

}
