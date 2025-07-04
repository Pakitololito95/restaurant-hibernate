package com.restaurant.dao;

import com.restaurant.model.Tisch;

public interface TischDao extends GenericDao<Tisch> {
    Tisch findByName(String name);
}
