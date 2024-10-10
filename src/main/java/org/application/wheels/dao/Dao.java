package org.application.wheels.dao;

import java.util.List;

public interface Dao<T> {
    public void save(T t);

    public T getById(String id);

    public List<T> findAll();

    public void update(T t);

    public void delete(T t);

    public void delete(String id);

    public void deleteAll();

    public void closeConnection();
}
