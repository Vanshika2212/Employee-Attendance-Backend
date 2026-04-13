package com.example.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.emp.model.User;
import com.example.emp.repository.UserRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository repo;

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        if (user.getUsername() == null || user.getPassword() == null) {
            return "FAIL";
        }

        User found = repo.findByUsername(user.getUsername());

        if (found != null && found.getPassword().equals(user.getPassword())) {
            return "SUCCESS";
        }

        return "FAIL";
    }
}