package com.restaurant.dao.impl;

import com.restaurant.dao.BestellungDao;
import com.restaurant.model.Bestellung;

public class BestellungDaoImpl extends GenericDaoImpl<Bestellung> implements BestellungDao {

    public BestellungDaoImpl() {
        super(Bestellung.class);
    }

    // Dodaj posebne metode ovde ako bude potrebno
}
