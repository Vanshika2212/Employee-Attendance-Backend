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

    System.out.println("Entered Username: " + user.getUsername());
    System.out.println("Entered Password: " + user.getPassword());

    // 🔥 TEMP HARDCODE (to avoid DB crash)
    if ("admin".equals(user.getUsername()) && "1234".equals(user.getPassword())) {
        return "SUCCESS";
    }

    return "FAIL";
}
