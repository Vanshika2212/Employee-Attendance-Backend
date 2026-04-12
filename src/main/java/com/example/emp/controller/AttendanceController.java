package com.example.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.emp.model.Attendance;
import com.example.emp.repository.AttendanceRepository;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
@CrossOrigin(origins = "*")
public class AttendanceController {

    @Autowired
    private AttendanceRepository repo;

    // ✅ SAVE attendance
    @PostMapping
    public Attendance saveAttendance(@RequestBody Attendance attendance) {
        return repo.save(attendance);
    }

    // ✅ GET all attendance
    @GetMapping
    public List<Attendance> getAllAttendance() {
        return repo.findAll();
    }
}