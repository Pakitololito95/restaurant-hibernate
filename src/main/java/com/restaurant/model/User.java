package com.restaurant.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private boolean active;

    public String getRole() {
        return role;
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isActive() {
        return active;
    }
}