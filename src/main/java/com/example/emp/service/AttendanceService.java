package com.example.emp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.emp.model.Attendance;
import com.example.emp.repository.AttendanceRepository;

import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository repo;

    public List<Attendance> getAll() {
        return repo.findAll();
    }

    public Attendance save(Attendance att) {
        return repo.save(att);
    }
}