package com.example.demo;

public interface GenericDAO<T> {

    void persist(T entity);
}
