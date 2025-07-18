package com.restaurant.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bestellposition")
public class Bestellposition {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private int menge;

    @Column(nullable = false)
    private double preis;

    @ManyToOne
    @JoinColumn(name = "bestellung_id", nullable = false)
    private Bestellung bestellung;

    @ManyToOne
    @JoinColumn(name = "gericht_id", nullable = false)
    private Gericht gericht;
}
