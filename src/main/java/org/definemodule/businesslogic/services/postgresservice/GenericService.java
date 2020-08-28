package org.definemodule.businesslogic.services.postgresservice;

import java.util.List;

public interface GenericService<T> {
    void update(T entity);
    void delete(T entiy);
    void insert(T entity);
    List<T> getAll();
    T getById(int id);
}
