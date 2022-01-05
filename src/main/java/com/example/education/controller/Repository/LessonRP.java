package com.example.education.controller.Repository;

import com.example.education.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface LessonRP extends JpaRepository<com.example.education.model.Lesson,Integer> {
    Lesson findById(int id);
    ArrayList<Lesson> findAll();
    ArrayList<Lesson> findAllByMaster_idOrderByTime1(int id);
}
