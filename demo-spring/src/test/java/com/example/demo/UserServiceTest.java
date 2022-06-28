package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { UserServiceImpl.class, UserHibernateDAO.class, JPAConfiguration.class})
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void test_CreateUser() {
        try {
            userService.createUser("hello");
        } catch (NoRollbackException ex) {
            // ignore
        }
    }
}
