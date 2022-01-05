package com.example.education.controller;

import com.example.education.controller.Repository.*;
import com.example.education.model.Lesson;
import com.example.education.model.Master;
import com.example.education.model.State;
import com.example.education.model.StudentLesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class MasterCtrl {
    @Autowired private StudentLessonRP slRP;
    @Autowired private MasterRP masterRP;
    @Autowired private StudentRP studentRP;
    @Autowired private LessonRP lessonRP;
    @Autowired private StateRP stateRP;

    public enum TableNames {
        student,
        master,
        lesson,
        studentLesson
    }

    @GetMapping("/master")
    public String master(
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
            Master master = masterRP.findById(Integer.parseInt(id));

            model.addAttribute("name",master.getName());
        }
        return "/parts/master/index";
    }

    @GetMapping("master/show-plan")
    public String masterShowPlan(
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
            if (id != null)
            {
                ArrayList<Lesson> allLs = lessonRP.findAllByMaster_idOrderByTime1(Integer.parseInt(id));
                model.addAttribute("msLs",allLs);
            }

        return "/parts/master/function/show-plan";
    }

    @GetMapping("master/insert-grade")
    public String masterInsertGrade(
            HttpServletRequest request,
            Model model,
            @RequestParam(value = "grade",required = false) String grade,
            @RequestParam(value = "stId",required = false) String stId,
            @RequestParam(value = "lsId",required = false) String lsId,
            @RequestParam(value = "searchId",required = false) String searchedId,
            @RequestParam(value = "searchlsId",required = false) String searchedlsId
    ){
//        Cookie[] cookies = request.getCookies();
//        String id = null;
//        for(Cookie el : cookies)
//        {
//            if("edu.ID".equals(el.getName()))
//            {
//                id = el.getValue();
//            }
//        }
//        if(grade != null)
//        {
//            if(stId != null & lsId != id)
//            {
//                if(Integer.parseInt(grade) >= 0 && Integer.parseInt(grade) <= 20)
//                {
//                    State stat = stateRP.findById(2);
//                    StudentLesson sl = slRP.findByStudent_IdAndLesson_IdAndTerm(Integer.parseInt(stId),Integer.parseInt(lsId),stat.getValue());
//                    sl.setScore(grade);
//                    slRP.save(sl);
//                }
//            }
//        }else if (searchedId != null){
//            StudentLesson allLesson = slRP.findLessonByLesson_Master_IdAndStudentIdAndLessonId(Integer.parseInt(id),Integer.parseInt(searchedId),Integer.parseInt(searchedlsId));
//            model.addAttribute("allLesson", allLesson);
//        }
//
//
//        return "/parts/master/function/insert-grade";
//
        return "/error";
}
}
