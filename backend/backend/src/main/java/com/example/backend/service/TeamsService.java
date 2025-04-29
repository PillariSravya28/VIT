package com.example.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.model.Teams;
import com.example.backend.repository.TeamsRepository;

@Service
public class TeamsService {
    @Autowired
    private TeamsRepository teamsRepository;
    public void createTeam(String leader){
        Teams t = new Teams();
        t.setLeader(leader);
        t.setMembers(null);
        t.setTeamname("TEAM NAME");
        teamsRepository.save(t);
    }
    public String updateTeam(String name,String leader){
        List<Teams> tm = teamsRepository.findByLeader(leader);
        if(tm!=null){
            Teams t = tm.get(0);
            t.setTeamname(name);
            teamsRepository.save(t);
            return "Team Updated";
        }
        else
            return "Not found";
    }
    public List<String> addmember(String member,String leader){
        List<Teams> tm = teamsRepository.findByLeader(leader);
        if(tm!=null){
            Teams t = tm.get(0);
            List<String> l = new ArrayList<>();
            if(t.getMembers()==null){
                l.add(member);
                t.setMembers(l);
            }
            else{
                if(!t.getMembers().contains(member)){
                    t.getMembers().add(member);
                }
            }
            teamsRepository.save(t);
            return t.getMembers();

        }
        else    
            return null;
    }
    public String getTeamName(String email){
        List<Teams> teams = teamsRepository.findByLeader(email);
        return teams.get(0).getTeamname();
    }
}
