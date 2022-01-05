package com.example.education.controller;

import com.example.education.controller.Repository.LessonRP;
import com.example.education.controller.Repository.MasterRP;
import com.example.education.controller.Repository.StudentLessonRP;
import com.example.education.controller.Repository.StudentRP;
import com.example.education.model.Lesson;
import com.example.education.model.Master;
import com.example.education.model.Student;
import com.example.education.model.StudentLesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class log {
    @Autowired private StudentRP studentRP;
    @Autowired private MasterRP masterRP;
    @Autowired private LessonRP lessonRP;
    @Autowired private StudentLessonRP studentLessonRP;

    @GetMapping("/log")
    public String log(
            @RequestParam(value = "table", required = false) String tb,
            @RequestParam(value = "userId", required = false) String uId,
            Model model
    ){

        if(tb != null && uId != null){
            if (tb.equals("student"))
            {
                Student obj;
                obj = studentRP.findById(Integer.parseInt(uId));
                model.addAttribute("log",obj.toString());
            }
            else if(tb.equals("master"))
            {
                Master obj;
                obj = masterRP.findById(Integer.parseInt(uId));
                model.addAttribute("log",obj.toString());
            }
            else if (tb.equals("lesson"))
            {
                Lesson obj;
                obj = lessonRP.findById(Integer.parseInt(uId));
                model.addAttribute("log",obj.toString());
            }else if (tb.equals("studentLesson"))
            {
                StudentLesson obj;
                obj = studentLessonRP.findById(Integer.parseInt(uId));
                model.addAttribute("log",obj.toString());
            }
        }
        return "/parts/log";
    }
}
