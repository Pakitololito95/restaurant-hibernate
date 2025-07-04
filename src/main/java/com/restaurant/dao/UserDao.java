package com.restaurant.dao;

import com.restaurant.model.User;

public interface UserDao extends GenericDao<User> {
    User findByUsername(String username);
}
