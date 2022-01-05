package com.example.education.controller;

import com.example.education.controller.Repository.*;
import com.example.education.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class StudentCtrl {
    @Autowired private StudentRP studentRP;
    @Autowired private StudentLessonRP studentLessonRP;
    @Autowired private MasterRP masterRP;
    @Autowired private LessonRP lessonRP;
    @Autowired private StateRP stateRP;

    public enum TableNames {
        student,
        master,
        lesson,
        studentLesson
    }

    @GetMapping("/student")
    public String student(
            HttpServletRequest request,
            Model model
    ) {
        Cookie[] cookies = request.getCookies();
        String id = null;

        for(Cookie el : cookies)
        {
            if("edu.ID".equals(el.getName()))
            {
                id = el.getValue();
            }
        }
        if(id != null) {
            Student student = studentRP.findById(Integer.parseInt(id));

            model.addAttribute("name",student.getName());
        }
        return "/parts/student/index";
    }

    @GetMapping("/student/show-ls")
    public String showLs(
            Model model
    )
    {
        ArrayList<Lesson> allLessons = lessonRP.findAll();
        model.addAttribute("lessons",allLessons);
        return "/parts/student/function/show-ls";
    }

    @GetMapping("/student/choose-ls")
    public String chooseLs(
            @RequestParam(value = "lsId",required = false) String lsId,
            Model model,
            HttpServletRequest request
    )
    {
        Cookie[] cookies = request.getCookies();
        String id = null;

        for(Cookie el : cookies)
        {
            if("edu.ID".equals(el.getName()))
            {
                id = el.getValue();
            }
        }

        State stateEn = stateRP.findById(1);
        if (stateEn.getValue().equals("1"))
        if (lsId != null){
            Lesson lesson = lessonRP.findById(Integer.parseInt(lsId));
            if(lesson != null) {
                State state = stateRP.findById(2);
                StudentLesson stls = studentLessonRP.findByStudent_IdAndLesson_IdAndTerm(Integer.parseInt(lsId),Integer.parseInt(id),state.getValue());
                System.out.println(stls);
                if(stls == null) {
                    Student st = studentRP.findById(Integer.parseInt(id));
                    StudentLesson saved = new StudentLesson(lesson,st,state.getValue());
                    saved = studentLessonRP.save(saved);
                    return "redirect:/log?table="+ StudentCtrl.TableNames.studentLesson.name() +"&userId=" + saved.getId();
                }
            }
        }
        model.addAttribute("confilict", "0");
        return "/parts/student/function/choose-ls";
    }
    @GetMapping("student/show-plan")
    public String shPlan(
            @RequestParam(value = "lsId",required = false) String lsId,
            Model model,
            HttpServletRequest request
    )
    {
        Cookie[] cookies = request.getCookies();
        String id = null;

        for(Cookie el : cookies)
        {
            if("edu.ID".equals(el.getName()))
            {
                id = el.getValue();
            }
        }

        ArrayList<StudentLesson> le = studentLessonRP.findAllLessonByStudent_IdOrderByLesson_Time1(Integer.parseInt(id));
        model.addAttribute("stLs",le);
        return "/parts/student/function/show-plan";
    }
}

