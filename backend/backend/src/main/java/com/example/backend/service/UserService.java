package com.example.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.model.User;
import com.example.backend.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean isEmailUnique(String email) {
        return userRepository.findByEmail(email) == null;
    }
    public boolean getEmail(String email){
        User use = userRepository.findByEmail(email);
        if(use != null && use.getPosition().equals("teammember")){
            return true;
        }
        return false;
    }

    public void signup(String fullName, String email, String username, String password,String position) {
        User user = new User();
        user.setFullName(fullName);
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
        user.setPosition(position);
        userRepository.save(user);
    }
    public String login(String email, String password,String position) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return "User not registered.";
        }
        if (!user.getPassword().equals(password)) {
            return "Incorrect password.";
        }
        if(!user.getPosition().equals(position)){
            System.out.println(user.getPosition() + " " + position);
            return "position mismatch";
        }
        return "Login successful.";
    }
}
