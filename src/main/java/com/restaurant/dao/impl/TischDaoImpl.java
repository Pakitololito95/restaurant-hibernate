package com.restaurant.dao.impl;

import com.restaurant.dao.TischDao;
import com.restaurant.model.Tisch;
import jakarta.persistence.TypedQuery;

public class TischDaoImpl extends GenericDaoImpl<Tisch> implements TischDao {

    public TischDaoImpl() {
        super(Tisch.class);
    }

    @Override
    public Tisch findByName(String name) {
        try {
            return entityManager.createQuery(
                            "SELECT t FROM Tisch t WHERE t.name = :name", Tisch.class)
                    .setParameter("name", name)
                    .getSingleResult();
        } catch (Exception e) {
            return null; // vraca nulu ukoliko nije pronadjeno
        }
    }
}
