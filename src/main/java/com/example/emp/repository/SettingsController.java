package com.example.emp.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.emp.model.Settings;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/settings")
public class SettingsController {

    @Autowired
    private JpaRepository<Settings, Long> repo;

    @PostMapping
    public Settings save(@RequestBody Settings s) {
        return repo.save(s);
    }

    @GetMapping
    public List<Settings> getAll() {
        return repo.findAll();
    }
}
