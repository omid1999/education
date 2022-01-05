package com.example.education.controller.Repository;

import com.example.education.model.Master;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MasterRP extends JpaRepository<com.example.education.model.Master,Integer> {
    Master findById(int id);
}
