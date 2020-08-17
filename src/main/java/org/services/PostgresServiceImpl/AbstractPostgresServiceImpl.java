package org.services.PostgresServiceImpl;

import com.sun.jdi.InterfaceType;
import org.persistence.GenericDAO;
import org.persistence.PostgresImpl.PostgresImplService;
import org.services.GenericService;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public abstract class AbstractPostgresServiceImpl<T> implements GenericService<T> {
    protected Class<T> type;
    protected GenericDAO<T> dao;

    public AbstractPostgresServiceImpl(GenericDAO<T> dao){
        this.dao = dao;
        Type t = dao.getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class<T>) pt.getActualTypeArguments()[0];
    }

    @Override
    public List<T> getAll() {
        return dao.getAll();
    }

    @Override
    public T getById(int id) {
        return dao.findById(id);
    }

    @Override
    public void delete(T entity) {
        dao.delete(entity);
    }

    @Override
    public void insert(T entity) {
        dao.insert(entity);
    }

    @Override
    public void update(T entity) {
        dao.update(entity);
    }

}
