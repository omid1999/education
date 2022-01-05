package com.example.education.controller.Repository;

import com.example.education.model.Lesson;
import com.example.education.model.Student;
import com.example.education.model.StudentLesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface StudentLessonRP extends JpaRepository<StudentLesson,Integer> {
    StudentLesson findById(int id);
    StudentLesson findByStudent_IdAndLesson_IdAndTerm(int Student_Id,int Lesson_Id,String Term);
    ArrayList<StudentLesson> findAllLessonByStudent_IdOrderByLesson_Time1(int id);
    ArrayList<StudentLesson> findAllLessonByLesson_Master_Id(int id);
    StudentLesson findLessonByLesson_Master_IdAndStudentIdAndLessonId(int masterId,int studentId,int lessonId);

//    @Query("SELECT p FROM Person p WHERE LOWER(p.lastName) = LOWER(:lastName)")
//    List<StudentLesson> find(@Param("lastName") String lastName);
}
