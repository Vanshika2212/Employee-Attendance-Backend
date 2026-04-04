package com.example.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.emp.model.Settings;

public interface SettingsRepository extends JpaRepository<Settings, Long> {}
