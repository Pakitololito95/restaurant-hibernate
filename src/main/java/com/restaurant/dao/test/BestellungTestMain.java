package com.restaurant.dao.test;

import com.restaurant.dao.TischDao;
import com.restaurant.dao.UserDao;
import com.restaurant.dao.impl.BestellungDaoImpl;
import com.restaurant.dao.impl.TischDaoImpl;
import com.restaurant.dao.impl.UserDaoImpl;
import com.restaurant.model.Bestellung;
import com.restaurant.model.Tisch;
import com.restaurant.model.User;

import java.time.LocalDateTime;


public class BestellungTestMain {
    public static void main(String[] args) {
        BestellungDaoImpl bestellungDao = new BestellungDaoImpl();

        // Testni user i tisch sa ID 1 — proveri da li postoje u bazi
        User user = new User();
        user.setUsername("User4");
        user.setPassword("Hemija95-");
        user.setRole("Admin");

        Tisch tisch = new Tisch();
        tisch.setName("A4");
        tisch.setStatus("Frai");


        UserDaoImpl userDao = new UserDaoImpl();
        userDao.delete(user);
        userDao.findByUsername(user.getUsername());
        if(userDao.findByUsername(user.getUsername()) == null){
            userDao.save(user);
        };
        TischDaoImpl tischDao = new TischDaoImpl();
        tischDao.delete(tisch);
        tischDao.findByName(tisch.getName());
        if(tischDao.findByName(tisch.getName()) == null){
        tischDao.save(tisch);}

        Bestellung bestellung = new Bestellung();
        bestellung.setBestellungszeit(LocalDateTime.now());
        bestellung.setStatus("OFFEN");
        bestellung.setUser(user);
        bestellung.setTisch(tisch);

        bestellungDao.save(bestellung);

        System.out.println("✅ Bestellung erforderlich gespeichert.");
    }
}
