package com.example.emp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user")  // must match your DB table name
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")  // must match DB column
    private String username;

    @Column(name = "password")  // must match DB column
    private String password;

    // ✅ IMPORTANT: Default constructor (fixes 500 error)
    public User() {
    }

    // ✅ Optional: Parameterized constructor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter for id
    public Long getId() {
        return id;
    }

    // Getter & Setter for username
    public String getUsername() {
        return username;
    }

public void setUsername(String username) {
        this.username = username;
    }

    // Getter & Setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // ✅ Optional: for debugging (very helpful)
    @Override
    public String toString() {
        return "User{id=" + id + ", username='" + username + "', password='" + password + "'}";
    }
}
