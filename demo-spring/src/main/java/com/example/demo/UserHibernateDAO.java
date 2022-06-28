package com.example.demo;

import org.springframework.stereotype.Repository;

@Repository
public class UserHibernateDAO extends GenericHibernateDAO<User> implements UserDAO {

    @Override
    public void persist(User user) {
        super.persist(user);
        throw new RuntimeException("dont rollback");
    }
}
