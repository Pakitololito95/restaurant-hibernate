package com.restaurant.test;

import com.restaurant.dao.BestellungDao;
import com.restaurant.dao.impl.BestellungDaoImpl;
import com.restaurant.model.Bestellung;

import java.time.LocalDateTime;
import java.util.List;

public class BestellungDaoTest {
    public static void main(String[] args) {
        BestellungDao dao = new BestellungDaoImpl();

        // Kreiranje nove porudzbine
        Bestellung bestellung = new Bestellung();
        bestellung.setBestellungszeit(LocalDateTime.now());
        bestellung.setStatus("OFFEN");  // Pretpostavljam da je ovo plain string

        dao.save(bestellung);
        System.out.println("Narudžbina sačuvana sa ID: " + bestellung.getId());

        // 2. uzmi sve porudzbine
        List<Bestellung> lista = dao.findAll();
        System.out.println("Sve narudžbine:");
        for (Bestellung b : lista) {
            System.out.println("ID: " + b.getId() + ", Status: " + b.getStatus() + ", Datum: " + b.getBestellungszeit());
        }
    }
}
