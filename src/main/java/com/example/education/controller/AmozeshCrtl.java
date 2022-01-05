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
import javax.servlet.http.HttpServletResponse;

@Controller
public class AmozeshCrtl {
    @Autowired private AmozeshRP amozeshRP;
    @Autowired private StudentRP studentRP;
    @Autowired private MasterRP masterRP;
    @Autowired private LessonRP lessonRP;
    @Autowired private StateRP stateRP;

    public enum TableNames {
        student,
        master,
        lesson
    }

    @GetMapping("/amozesh")
    public String amozesh(
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
            Amozesh amozesh = amozeshRP.findById(Integer.parseInt(id));
            model.addAttribute("name",amozesh.getName());
        }
        return "/parts/amozesh/index";
    }

    //templates/parts/amozesh/function
    @GetMapping("amozesh/make-st")
    public String amozeshMakeSt(
            @RequestParam(value = "fullName",required = false) String name,
            @RequestParam(value = "fatherName", required = false) String fatherName,
            @RequestParam(value = "naId", required = false) String naCode,
            Model state
    ) {
        Student input;
        if(name != null && fatherName != null && naCode != null)
        {
            input = new Student(name,naCode,fatherName);
            Student saved = studentRP.save(input);
            System.out.println(saved);
            return "redirect:/log?table="+ TableNames.student.name() +"&userId=" + saved.getId();
        }
        return "/parts/amozesh/function/make-st";
    }

    @GetMapping("amozesh/make-ms")
    public String amozeshMakeMs(
            @RequestParam(value = "fullName",required = false) String name,
            @RequestParam(value = "filed", required = false) String filed,
            @RequestParam(value = "naId", required = false) String naCode,
            Model state
    ) {
        Master input;
        if(name != null && filed != null && naCode != null)
        {
            input = new Master(name,naCode,filed);
            Master saved = masterRP.save(input);
            System.out.println(TableNames.master.name());
            return "redirect:/log?table="+ TableNames.master.name() +"&userId=" + saved.getId();
        }
        return "/parts/amozesh/function/make-ms";
    }

    @GetMapping("amozesh/edit-st")
    public String amozeshEditSt(
            @RequestParam(value = "serachId", required = false) String id,
            @RequestParam(value = "fullName", required = false) String name,
            @RequestParam(value = "fatherName",required = false) String fName,
            @RequestParam(value = "naId",required = false) String naCode,
            Model model,
            HttpServletResponse response,
            HttpServletRequest request
    ) {
        Student student;
        if(id != null) {
            student = studentRP.findById(Integer.parseInt(id));
            if (student != null) {
                model.addAttribute("student", student);
                Cookie sreachedUser = new Cookie("edu.searchedId",id);
                response.addCookie(sreachedUser);
            }
        }else if(name != null && fName != null && naCode != null) {
            Cookie[] cookies = request.getCookies();
            for(Cookie el : cookies)
            {
                if("edu.searchedId".equals(el.getName()))
                {
                    id = el.getValue();
                }
            }

            student = studentRP.findById(Integer.parseInt(id));
            student.setFatherName(fName);
            student.setName(name);
            student.setNationalCode(naCode);
            studentRP.save(student);
            return "redirect:/log?table="+ TableNames.student.name() +"&userId=" + id;
        }
        return "/parts/amozesh/function/edit-st";
    }

    @GetMapping("amozesh/edit-ms")
    public String amozeshEditMs(
        @RequestParam(value = "serachId", required = false) String id,
        @RequestParam(value = "fullName", required = false) String name,
        @RequestParam(value = "field",required = false) String field,
        @RequestParam(value = "naId",required = false) String naCode,
        Model model,
        HttpServletResponse response,
        HttpServletRequest request
    ) {
            Master master;
            if(id != null) {
                master = masterRP.findById(Integer.parseInt(id));
                if (master != null) {
                    model.addAttribute("master", master);
                    Cookie sreachedUser = new Cookie("edu.searchedId",id);
                    response.addCookie(sreachedUser);
                }
            }else if(name != null && field != null && naCode != null) {
                Cookie[] cookies = request.getCookies();
                for(Cookie el : cookies)
                {
                    if("edu.searchedId".equals(el.getName()))
                    {
                        id = el.getValue();
                    }
                }

                master = masterRP.findById(Integer.parseInt(id));
                master.setField(field);
                master.setName(name);
                master.setNationalCode(naCode);
                masterRP.save(master);
                return "redirect:/log?table="+ TableNames.master.name() +"&userId=" + id;
            }
        return "/parts/amozesh/function/edit-ms";
    }

    @GetMapping("amozesh/make-ls")
    public String amozeshMakeLs(
            @RequestParam(value = "lessonName", required = false) String name,
            @RequestParam(value = "masterName", required = false) String msId,
            @RequestParam(value = "examDate", required = false) String examDate,
            @RequestParam(value = "day1", required = false) String day1,
            @RequestParam(value = "hour1", required = false) String hour1,
            @RequestParam(value = "oddEven1", required = false)String oddEven1,
            @RequestParam(value = "day2", required = false) String day2,
            @RequestParam(value = "hour2", required = false) String hour2,
            @RequestParam(value = "oddEven2", required = false)String oddEven2
    ) {
        if(name != null &&
           msId != null &&
           examDate != null &&
           day1 != null &&
           hour1 != null &&
           oddEven1 != null)
        {
            Master master = masterRP.findById(Integer.parseInt(msId));
            if (master != null) {
                Lesson lesson = new Lesson(name,master,examDate,(day1+hour1+oddEven1));
                if( day2 != "no" && hour2 != "no" && oddEven2 != "no") {
                    lesson.setTime2(day2+hour2+oddEven2);
                }
                Lesson saved = lessonRP.save(lesson);
                return "redirect:/log?table="+ TableNames.lesson.name() +"&userId=" + saved.getId();
            }
        }
        return "/parts/amozesh/function/make-ls";
    }

    @GetMapping("amozesh/edit-ls")
    public String amozeshEditLs(
            @RequestParam(value = "searchId", required = false) String id,
            @RequestParam(value = "lessonName", required = false) String name,
            @RequestParam(value = "masterId", required = false) String msId,
            @RequestParam(value = "examDate", required = false) String examDate,
            @RequestParam(value = "day1", required = false) String day1,
            @RequestParam(value = "hour1", required = false) String hour1,
            @RequestParam(value = "oddEven1", required = false)String oddEven1,
            @RequestParam(value = "day2", required = false) String day2,
            @RequestParam(value = "hour2", required = false) String hour2,
            @RequestParam(value = "oddEven2", required = false)String oddEven2,
            Model model,
            HttpServletResponse response,
            HttpServletRequest request
    ) {
            Lesson lesson;
            if(id != null) {
                lesson = lessonRP.findById(Integer.parseInt(id));
                if (lesson != null) {
                    model.addAttribute("lesson", lesson);
                    Cookie sreachedLs = new Cookie("edu.searchedId",id);
                    response.addCookie(sreachedLs);
                }
            }else if(name != null &&
                    msId != null &&
                    examDate != null &&
                    day1 != null &&
                    hour1 != null &&
                    oddEven1 != null)
            {
                Cookie[] cookies = request.getCookies();
                for (Cookie el : cookies) {
                    if ("edu.searchedId".equals(el.getName())) {
                        id = el.getValue();
                    }
                }
                Master master = masterRP.findById(Integer.parseInt(msId));
                if (master != null) {
                    Lesson lesson1 = lessonRP.findById(Integer.parseInt(id));
                    lesson1.setName(name);
                    lesson1.setTime1(day1+hour1+oddEven1);
                    lesson1.setMaster(master);
                    lesson1.setExamDate(examDate);
                    System.out.println(lesson1);
                    if( day2 != "no" && hour2 != "no" && oddEven2 != "no") {
                        lesson1.setTime2(day2+hour2+oddEven2);
                    }
                    Lesson saved = lessonRP.save(lesson1);
                    return "redirect:/log?table="+ TableNames.lesson.name() +"&userId=" + saved.getId();
                }
            }
        return "/parts/amozesh/function/edit-ls";
    }
    @GetMapping("/amozesh/enable-uc")
    public String enUnit(
            @RequestParam(value = "state", required = false) String state,
            Model model
    ) {
        State newState;
        newState = stateRP.findById(1);

        if(state != null) {
            newState.setValue(state);
            stateRP.save(newState);
            System.out.println(newState);
            model.addAttribute("state",state);
        }else {
            model.addAttribute("state",newState.getValue());
        }
        return "/parts/amozesh/function/enable-uc";
    }
}
