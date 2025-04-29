package com.example.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.backend.dto.TeamUpdate;
import com.example.backend.service.TeamsService;

@Controller
@RequestMapping("/team")
@CrossOrigin(origins = "http://localhost:8081/")
public class TeamController {
    @Autowired
    private TeamsService teamsService;
    
    @PostMapping("/create/{lead}")
    public void createTeam(@PathVariable("lead") String leader){
        teamsService.createTeam(leader);
    }
    @PutMapping("/update")
    public ResponseEntity<String> upString(@RequestBody TeamUpdate teamUpdate){
        String teamname = teamUpdate.getTeamname();
        String email = teamUpdate.getEmail();
        String a = teamsService.updateTeam(teamname, email);
        if(a=="Team Updated")
           return ResponseEntity.status(200).body(a);
        return ResponseEntity.status(500).build();
    }
    @PostMapping("/addmember")
    public ResponseEntity<List<String>> addmember(@RequestParam String member,@RequestParam String leader){
        List<String> te = teamsService.addmember(member, leader);
        return ResponseEntity.status(200).body(te);
    }
    @GetMapping("/getTeamname")
    public ResponseEntity<String> getTeamName(@RequestParam String email){
        String a = teamsService.getTeamName(email);
        return ResponseEntity.status(200).body(a);
    }
    
}
