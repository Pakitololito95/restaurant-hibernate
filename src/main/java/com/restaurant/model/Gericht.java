package com.restaurant.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gericht")
public class Gericht {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double preis;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "kategorie_id", nullable = false)
    private Kategorie kategorie;

    @OneToMany(mappedBy = "gericht")
    private List<Bestellposition> bestellpositionen;
}
