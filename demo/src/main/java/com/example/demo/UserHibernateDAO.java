package com.example.demo;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserHibernateDAO implements UserDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void create(String name) {

        User user = new User();
        user.setName(name);

        entityManager.persist(user);

        throw new RuntimeException("test rollback");
    }

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("from User")
                .getResultList();
    }
}
