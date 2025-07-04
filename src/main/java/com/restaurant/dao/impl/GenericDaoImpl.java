package com.restaurant.dao.impl;

import com.restaurant.dao.GenericDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import com.restaurant.util.JpaUtil;

import java.util.List;

public class GenericDaoImpl<T> implements GenericDao<T> {

    private final Class<T> entityClass;
    protected EntityManager entityManager;

    public GenericDaoImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
        this.entityManager = JpaUtil.getEntityManager();
    }

    @Override
    public void save(T entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(entity);
        transaction.commit();
    }

    @Override
    public T findById(Long id) {
        return entityManager.find(entityClass, id);
    }

    @Override
    public List<T> findAll() {
        return entityManager.createQuery("FROM " + entityClass.getSimpleName(), entityClass).getResultList();
    }

    @Override
    public void update(T entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(entity);
        transaction.commit();
    }

    @Override
    public void delete(T entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
        transaction.commit();
    }
}
