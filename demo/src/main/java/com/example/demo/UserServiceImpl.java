package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    @Transactional(noRollbackFor = NoRollbackException.class)
    public void createUser(String name) {
        try {
            userDAO.create(name);
        } catch(Exception ex) {
            if (ex.getMessage().equals("dont rollback")) {
                throw new NoRollbackException(ex.getMessage());
            }
            throw ex;
        }
    }

    @Override
    public List<User> findAllUsers() {
        return userDAO.findAll();
    }

    @Override
    @Transactional
    public void flushAndClear() {
        userDAO.flushAndClear();
    }
}
