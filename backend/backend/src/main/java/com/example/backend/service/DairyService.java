package com.example.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.model.Dairy;
import com.example.backend.repository.DairyRepository;

@Service
public class DairyService {
    @Autowired
    private DairyRepository dairyRepository;
    
    public String postDairy(String email,String note){
        Dairy d = new Dairy();
        d.setDairynote(note);
        d.setEmail(email);
        dairyRepository.save(d);
        return "Saved";
    }

    public List<Dairy> getDairy(String email){
        return dairyRepository.findByEmail(email);
    }

    public void deleteDairy(Long id){
        dairyRepository.deleteById(id);
    }
}
