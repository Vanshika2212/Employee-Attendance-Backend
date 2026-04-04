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

    System.out.println("Entered Username: [" + user.getUsername() + "]");
    System.out.println("Entered Password: [" + user.getPassword() + "]");

    User u = repo.findByUsername(user.getUsername());

    if (u == null) {
        System.out.println("❌ USER NOT FOUND IN DB");
        return "FAIL";
    }

    System.out.println("DB Username: [" + u.getUsername() + "]");
    System.out.println("DB Password: [" + u.getPassword() + "]");

    // Compare manually
    if (u.getPassword().equals(user.getPassword())) {
        System.out.println("✅ MATCH SUCCESS");
        return "SUCCESS";
    } else {
        System.out.println("❌ PASSWORD MISMATCH");
        return "FAIL";
    }
}
}