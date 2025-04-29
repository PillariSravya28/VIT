package com.example.backend.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.dto.LoginForm;
import com.example.backend.dto.SignupForm;
import com.example.backend.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:8081/")
public class UserController{

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public String signup(@RequestBody SignupForm signupForm) {
        String fullName = signupForm.getFullName();
        String email = signupForm.getEmail();
        String username = signupForm.getUsername();
        String password = signupForm.getPassword();
        String position = signupForm.getPosition();

        if (!userService.isEmailUnique(email)) {
            return "Email already exists.";
        }

        userService.signup(fullName, email, username, password,position);
        return "User registered successfully!";
    }
    @PostMapping("/login")
    public String login(@RequestBody LoginForm loginForm) {
        String email = loginForm.getEmail();
        String password = loginForm.getPassword();
        String position = loginForm.getPosition();
        return userService.login(email, password,position);
    }
    @GetMapping("/getemail")
    public boolean getem(@RequestParam String email){
        boolean b =  userService.getEmail(email);
        return b;
    }
}
