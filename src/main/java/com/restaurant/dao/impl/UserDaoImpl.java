package com.restaurant.dao.impl;

import com.restaurant.dao.UserDao;
import com.restaurant.model.User;
import jakarta.persistence.TypedQuery;

public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

    public UserDaoImpl() {
        super(User.class);
    }

    @Override
    public User findByUsername(String username) {
        try {
            return entityManager.createQuery(
                            "SELECT u FROM User u WHERE u.username = :username", User.class)
                    .setParameter("username", username)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}