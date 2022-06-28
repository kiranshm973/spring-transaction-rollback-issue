package com.example.demo;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class GenericHibernateDAO<T> implements GenericDAO<T> {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public void persist(T entity) {
        entityManager.persist(entity);
    }
}
