package com.example.education.controller.Repository;

import com.example.education.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRP extends JpaRepository<com.example.education.model.State,Integer> {
    State findById(int id);
}
