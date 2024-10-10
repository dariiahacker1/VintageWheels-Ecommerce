package org.application.wheels.service;

import org.application.wheels.dao.Dao;

import java.util.List;

public abstract class AbstractService<T> implements Service<T> {
    private final Dao<T> dao;

    protected AbstractService(Dao<T> dao) { this.dao = dao; }

    public void saveEntity(T entity) { dao.save(entity); }

    public T getEntityById(String id) { return dao.getById(id); }

    public List<T> findAll() { return dao.findAll(); }

    public void updateEntity(T entity) { dao.update(entity); }

    public void deleteEntity(T entity) { dao.delete(entity); }

    public void deleteEntity(String id) { dao.delete(id); }

    public void deleteAllEntities() { dao.deleteAll(); }

    public void closeConnection() { dao.closeConnection(); }
}
