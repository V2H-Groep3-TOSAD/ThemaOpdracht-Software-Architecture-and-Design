package org.services;

import org.w3c.dom.Entity;

import java.util.List;

public interface GenericService<T> {
    void update(T entity);
    void delete(T entiy);
    void insert(T entity);
    List<T> getAll();
    T getById(int id);
}
