package com.projects.dao.interfaces;

public interface CommonDAO<T> {

    T get(Long id);

    void update(T obj);

    void delete(Long id);

    void add(T obj);

}
