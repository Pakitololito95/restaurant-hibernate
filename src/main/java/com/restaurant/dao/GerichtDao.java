package com.restaurant.dao;

import com.restaurant.model.Gericht;

public interface GerichtDao extends GenericDao<Gericht> {
    Gericht findByName(String name);
}
