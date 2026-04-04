package com.example.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.emp.model.LeaveRequest;

public interface LeaveRepository extends JpaRepository<LeaveRequest, Long> {
}
