package com.example.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.model.Mentor;
import com.example.backend.repository.MentorRepository;

@Service
public class MentorService {
    @Autowired
    private MentorRepository mentorRepository;

    public boolean isEmailUnique(String email) {
        return mentorRepository.findByEmail(email) == null;
    }
    
    public void mentorRegister(Mentor mentor){
        mentorRepository.save(mentor);
    }
    public List<Mentor> getdetails(){
        return mentorRepository.findAll();
    }
}
