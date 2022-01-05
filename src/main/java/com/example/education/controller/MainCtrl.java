package com.example.education.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainCtrl {
//
//    @Autowired private AmozeshRP amozeshRP;
//    @Autowired private StudentRP studentRP;
//    @Autowired private MasterRP masterRP;

    @GetMapping("/error")
    public String sessionOver()
    {
        return "/error";
    }

}
