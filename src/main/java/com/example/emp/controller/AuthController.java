package com.example.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.emp.model.User;
import com.example.emp.repository.UserRepository;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController {

    @Autowired
    private UserRepository repo;

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        // Debug logs (VERY IMPORTANT)
        System.out.println("Entered Username: " + user.getUsername());
        System.out.println("Entered Password: " + user.getPassword());

        // Check null
        if (user.getUsername() == null || user.getPassword() == null) {
            return "FAIL";
        }

        // Temporary login (for testing)
        if (user.getUsername().equals("admin") && user.getPassword().equals("admin")) {
            return "SUCCESS";
        }

        return "FAIL";
    }
}