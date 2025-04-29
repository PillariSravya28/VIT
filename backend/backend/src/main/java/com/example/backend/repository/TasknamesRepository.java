package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.model.Tasknames;
import java.util.List;


public interface TasknamesRepository extends JpaRepository<Tasknames,Long>{
    public List<Tasknames> findByAssignedby(String assignedby);
    
} 
