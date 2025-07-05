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
@Table(name = "tische")
public class Tisch {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String status;

    @OneToMany(mappedBy = "tisch", cascade = CascadeType.ALL)
    private List<Bestellung> bestellungen;

    @OneToMany(mappedBy = "tisch")
    private List<Reservierung> reservierungen;


}
