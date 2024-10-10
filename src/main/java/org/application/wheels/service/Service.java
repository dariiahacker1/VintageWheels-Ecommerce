package org.application.wheels.service;

import java.util.List;

public interface Service<T> {
    public void saveEntity(T entity);

    public T getEntityById(String id);

    public List<T> findAll();

    public void updateEntity(T entity);

    public void deleteEntity(T entity);

    public void deleteEntity(String id);

    public void deleteAllEntities();

    public void closeConnection();
}