package com.example.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.emp.model.LeaveRequest;
import com.example.emp.repository.LeaveRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/leave")
public class LeaveController {

    @Autowired
    private LeaveRepository repo;

    // Add leave request
    @PostMapping
    public LeaveRequest addLeave(@RequestBody LeaveRequest leave) {
        leave.setStatus("PENDING");
        return repo.save(leave);
    }

    // Get all leave requests
    @GetMapping
    public List<LeaveRequest> getAll() {
        return repo.findAll();
    }
}
