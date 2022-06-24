package com.example.demo;

import java.util.List;

public interface UserService {

    void createUser(String name);

    List<User> findAllUsers();

    void flushAndClear();
}
