package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.model.Dairy;
import java.util.List;


public interface DairyRepository extends JpaRepository<Dairy,Long>{
    public List<Dairy> findByEmail(String email);
}
