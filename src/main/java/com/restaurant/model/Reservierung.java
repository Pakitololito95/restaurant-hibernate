package com.restaurant.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservierung")
public class Reservierung {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDateTime uhrzeit;

    @Column(nullable = false)
    private int personenanzahl;

    @Column
    private String bemerkungen;

    @Column(nullable = false)
    private String kontakt;

    @ManyToOne
    @JoinColumn(name = "tisch_id", nullable = false)
    private Tisch tisch;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
