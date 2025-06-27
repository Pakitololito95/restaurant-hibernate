
package com.restaurant.controller;

import com.restaurant.model.User;
import jakarta.persistence.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label messageLabel;

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("restaurantPU");

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<User> query = em.createQuery(
                "SELECT u FROM User u WHERE u.username = :username AND u.password = :password AND u.active = true",
                User.class
            );
            query.setParameter("username", username);
            query.setParameter("password", password);
            User user = query.getSingleResult();
            messageLabel.setText("Angemeldet als: " + user.getRole());
        } catch (NoResultException e) {
            messageLabel.setText("Falscher Benutzername oder Passwort.");
        } finally {
            em.close();
        }
    }
}
