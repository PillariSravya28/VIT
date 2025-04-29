package com.example.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.model.InternLinks;
import com.example.backend.repository.InternRepository;

@Service
public class InternService {
    @Autowired
    private InternRepository internRepository;
    public String addIntern(String email,String link){
        InternLinks i = new InternLinks();
        i.setAddedby(email);
        i.setLink(link);
        internRepository.save(i);
        return "Link Added";
    }
    public List<InternLinks> getIntern(){
        List<InternLinks> i = internRepository.findAll();
        return i;
    }
    public void deleteIntern(Long id){
        internRepository.deleteById(id);
    }

}
