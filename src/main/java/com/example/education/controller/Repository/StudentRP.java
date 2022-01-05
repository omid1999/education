package com.example.education.controller.Repository;

import com.example.education.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRP extends JpaRepository<com.example.education.model.Student,Integer> {
    Student findById(int id);

}