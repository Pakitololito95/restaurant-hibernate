package com.restaurant.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bestellungen")
public class Bestellung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "tisch_id")
    private Tisch tisch;

    @OneToMany(mappedBy = "bestellung", cascade = CascadeType.ALL)
    private List<Bestellposition> bestellpositionen;

    @OneToOne(mappedBy = "bestellung", cascade = CascadeType.ALL)
    private Rechnung rechnung;

    @Column(nullable = false)
    private Date bestellungszeit;
}
