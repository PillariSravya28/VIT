package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.model.InternLinks;

@Repository
public interface InternRepository extends JpaRepository<InternLinks,Long>{
    
}
