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
@Table(name = "rechnung")
public class Rechnung {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String zahlungsart;

    @Column
    private double trinkgeld;

    @Column(nullable = false)
    private double gesamtbetrag;

    @Column(nullable = false)
    private String zahlungsstatus;

    @OneToOne
    @JoinColumn(name = "bestellung_id", nullable = false)
    private Bestellung bestellung;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
