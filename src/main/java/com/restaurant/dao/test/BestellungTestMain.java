package com.restaurant.dao.test;

import com.restaurant.dao.impl.BestellungDaoImpl;
import com.restaurant.model.Bestellung;
import com.restaurant.model.Tisch;
import com.restaurant.model.User;

import java.time.LocalDateTime;

public class BestellungTestMain {
    public static void main(String[] args) {
        BestellungDaoImpl bestellungDao = new BestellungDaoImpl();

        // Testni user i tisch sa ID 1 — proveri da li postoje u bazi
        User user = new User();
        user.setId(1L);

        Tisch tisch = new Tisch();
        tisch.setId(1L);

        Bestellung bestellung = new Bestellung();
        bestellung.setBestellungszeit(LocalDateTime.now());
        bestellung.setStatus("OFFEN");
        bestellung.setUser(user);
        bestellung.setTisch(tisch);

        bestellungDao.save(bestellung);

        System.out.println("✅ Bestellung erforderlich gespeichert.");
    }
}
