package com.restaurant.dao.impl;

import com.restaurant.dao.GerichtDao;
import com.restaurant.model.Gericht;
import jakarta.persistence.TypedQuery;

public class GerichtDaoImpl extends GenericDaoImpl<Gericht> implements GerichtDao {

    public GerichtDaoImpl() {
        super(Gericht.class);
    }

    @Override
    public Gericht findByName(String name) {
        TypedQuery<Gericht> query = entityManager.createQuery(
                "SELECT g FROM Gericht g WHERE g.name = :name", Gericht.class);
        query.setParameter("name", name);
        return query.getResultStream().findFirst().orElse(null);
    }
}
