package com.restaurant.dao;

import com.restaurant.model.Kategorie;

public interface KategorieDao extends GenericDao<Kategorie> {
    Kategorie findByName(String name);
}
