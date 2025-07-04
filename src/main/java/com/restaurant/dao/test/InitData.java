package com.restaurant.dao.test;

import com.restaurant.dao.impl.TischDaoImpl;
import com.restaurant.dao.impl.UserDaoImpl;
import com.restaurant.model.Tisch;
import com.restaurant.model.User;

public class InitData {
    public static void main(String[] args) {
        TischDaoImpl tischDao = new TischDaoImpl();
        UserDaoImpl userDao = new UserDaoImpl();

        // Test User
        User existingUser = userDao.findByUsername("testuser");
        if (existingUser == null) {
            User user = new User();
            user.setUsername("testuser");
            user.setPassword("1234");
            user.setRole("MITARBEITER");
            user.setActive(true);
            userDao.save(user);
            System.out.println("✅ User 'testuser' erstellt.");
        } else {
            System.out.println("ℹ️ User 'testuser' schon existiert.");
        }

        // Test Tischh
        Tisch existingTisch = tischDao.findByName("Tisch 1");
        if (existingTisch == null) {
            Tisch tisch = new Tisch();
            tisch.setName("Tisch 1");
            tisch.setStatus("FREI");
            tischDao.save(tisch);
            System.out.println("✅ Tisch 'Tisch 1' erstellt.");
        } else {
            System.out.println("ℹ️ Tisch 'Tisch 1' existiert bereits.");
        }

        System.out.println("✅ InitData abgeschlossen!");
    }
}
