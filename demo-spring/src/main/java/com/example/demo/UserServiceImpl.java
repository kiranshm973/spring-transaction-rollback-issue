package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    @Transactional(noRollbackFor = NoRollbackException.class)
    public void createUser(String name) {
        try {
            User user = new User();
            user.setName(name);
            userDAO.persist(user);
        } catch(Exception ex) {
            if (ex.getMessage().equals("dont rollback")) {
                throw new NoRollbackException(ex.getMessage());
            }
            throw ex;
        }
    }
}
