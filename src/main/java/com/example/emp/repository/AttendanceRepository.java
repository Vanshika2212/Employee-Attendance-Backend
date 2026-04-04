package com.example.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.emp.model.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
}
