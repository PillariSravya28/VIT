package com.example.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.backend.model.Mentor;
import com.example.backend.service.MentorService;


@Controller
@RequestMapping("/mentor")
public class MentorController {
    @Autowired
    private MentorService mentorService;

    @PostMapping("/post")
    public ResponseEntity<String> signup(@RequestParam String name,@RequestParam String email,@RequestParam String experience) {
        Mentor mentor = new Mentor();
        mentor.setEmail(email);
        mentor.setExperience(experience);
        mentor.setName(name);
        if (!mentorService.isEmailUnique(email)) {
            return ResponseEntity.status(200).body("Email already exists.");
        }
        mentorService.mentorRegister(mentor);
        return ResponseEntity.status(200).body("Registered Successfully!");
    }
    @GetMapping("/getdetails")
    public ResponseEntity<List<Mentor>> getdetails(){
        return ResponseEntity.status(200).body(mentorService.getdetails());
    }


}
