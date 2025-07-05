package com.restaurant.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private boolean active;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Bestellung> bestellungen;

    @OneToMany(mappedBy = "user")
    private List<Rechnung> rechnungen;

    @OneToMany(mappedBy = "user")
    private List<Reservierung> reservierungen;
}
