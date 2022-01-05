package com.example.education.controller;

import com.example.education.controller.Repository.AmozeshRP;
import com.example.education.controller.Repository.MasterRP;
import com.example.education.controller.Repository.StudentRP;
import com.example.education.model.Amozesh;
import com.example.education.model.Master;
import com.example.education.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginCtrl {
    @Autowired private AmozeshRP amozeshRP;
    @Autowired private StudentRP studentRP;
    @Autowired private MasterRP masterRP;

    @GetMapping("/")
    public String main(
            @RequestParam(value = "userId",required = false) String id ,
            @RequestParam(value = "who",required = false) String who,
            HttpServletResponse response,
            HttpServletRequest request
    ) {
        Amozesh amozesh = null;
        Student student = null;
        Master master = null;

        Cookie eduId = new Cookie("edu.ID", "");
        Cookie eduSeId = new Cookie("edu.searchedId","");

        response.addCookie(eduId);
        response.addCookie(eduSeId);

        if(id != null)
            switch (who) {
                case "amozesh":
                    amozesh = amozeshRP.findById(Integer.parseInt(id));
                    if(amozesh != null)
                    {
                        //session cookie
                        Cookie cookie = new Cookie("edu.ID", id.toString());
                        response.addCookie(cookie);
                        return "redirect:/amozesh";
                    }
                    return "redirect:/";
                case "student":
                    student = studentRP.findById(Integer.parseInt(id));
                    if(student != null)
                    {
                        //session cookie
                        Cookie cookie = new Cookie("edu.ID", id.toString());
                        response.addCookie(cookie);
                        return "redirect:/student";
                    }
                    return "redirect:/";
                case "master":
                    master = masterRP.findById(Integer.parseInt(id));
                    if(master != null)
                    {
                        //session cookie
                        Cookie cookie = new Cookie("edu.ID", id.toString());
                        response.addCookie(cookie);
                        return "redirect:/master";
                    }
                    return "redirect:/";
            }
        return "index";
    }
}
