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

    // Update leave status
   @PutMapping("/{id}/{status}")
public LeaveRequest updateStatus(@PathVariable Long id, @PathVariable String status) {

    LeaveRequest leave = repo.findById(id).orElse(null);

    if (leave == null) {
        System.out.println("❌ Leave not found");
        return null;
    }


    System.out.println("Updating ID: " + id + " to " + status);

    leave.setStatus(status);

    return repo.save(leave);
}
}