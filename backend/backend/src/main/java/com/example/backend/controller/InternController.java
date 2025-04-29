package com.example.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.backend.model.InternLinks;
import com.example.backend.service.InternService;

@Controller
@RequestMapping("/intern")
public class InternController {
    @Autowired
    private InternService internService;
    @PostMapping("/add")
    public ResponseEntity<String> addLink(@RequestParam String email,@RequestParam String link){
        String a = internService.addIntern(email, link);
        return ResponseEntity.status(200).body(a);
    }
    @GetMapping("/getTabledetails")
    public ResponseEntity<List<InternLinks>> getLink(){
        return ResponseEntity.status(200).body(internService.getIntern());
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteintern(@PathVariable("id") Long id){
        try{
            internService.deleteIntern(id);
            return ResponseEntity.ok().build();
        }
        catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
