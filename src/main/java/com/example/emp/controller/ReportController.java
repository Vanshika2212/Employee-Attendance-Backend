package com.example.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.emp.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin(origins = "*")
public class ReportController {

    @Autowired
    private EmployeeRepository employeeRepo;

    @GetMapping("/count")
    public long getEmployeeCount() {
        return employeeRepo.count();
    }
}