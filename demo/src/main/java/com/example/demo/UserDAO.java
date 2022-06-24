package com.example.demo;

import java.util.List;

public interface UserDAO {

    void create(String name);

    List<User> findAll();

    void flushAndClear();
}
