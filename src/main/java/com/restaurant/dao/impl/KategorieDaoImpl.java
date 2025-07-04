package com.restaurant.dao.impl;

import com.restaurant.dao.KategorieDao;
import com.restaurant.model.Kategorie;
import jakarta.persistence.TypedQuery;

public class KategorieDaoImpl extends GenericDaoImpl<Kategorie> implements KategorieDao {

    public KategorieDaoImpl() {
        super(Kategorie.class);
    }

    @Override
    public Kategorie findByName(String name) {
        TypedQuery<Kategorie> query = entityManager.createQuery(
                "SELECT k FROM Kategorie k WHERE k.name = :name", Kategorie.class);
        query.setParameter("name", name);
        return query.getResultStream().findFirst().orElse(null);
    }
}
