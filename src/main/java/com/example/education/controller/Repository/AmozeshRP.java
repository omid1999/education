package com.example.education.controller.Repository;

import com.example.education.model.Amozesh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmozeshRP extends JpaRepository<Amozesh, Integer> {
    Amozesh findById(int id);
}
