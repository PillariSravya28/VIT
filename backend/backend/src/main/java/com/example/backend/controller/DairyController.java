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

import com.example.backend.model.Dairy;
import com.example.backend.service.DairyService;

@Controller
@RequestMapping("/dairy")
public class DairyController {
    @Autowired
    private DairyService dairyService;

    @PostMapping("/post")
    public ResponseEntity<String> postDairy(@RequestParam String email,@RequestParam String dairynote){
        return ResponseEntity.status(200).body(dairyService.postDairy(email,dairynote));
    }

    @GetMapping("/get/{email}")
    public ResponseEntity<List<Dairy>> getDairies(@PathVariable("email") String email){
        return ResponseEntity.status(200).body(dairyService.getDairy(email));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteintern(@PathVariable("id") Long id){
        try{
            dairyService.deleteDairy(id);
            return ResponseEntity.ok().build();
        }
        catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
