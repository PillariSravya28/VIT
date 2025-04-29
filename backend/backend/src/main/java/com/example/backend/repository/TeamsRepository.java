package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.model.Teams;
import java.util.List;


public interface TeamsRepository extends JpaRepository<Teams,Long>{
    public List<Teams> findByLeader(String leader);
} 
