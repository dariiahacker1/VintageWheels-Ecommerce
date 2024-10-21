package org.application.wheels.service;

import org.application.wheels.dao.Dao;

import java.util.List;

public abstract class AbstractService<T> implements Service<T> {
    private final Dao<T> dao;

    protected AbstractService(Dao<T> dao) { this.dao = dao; }

    @Override
    public void saveEntity(T entity) { dao.save(entity); }

    @Override
    public T getEntityById(String id) { return dao.getById(id); }

    @Override
    public List<T> findAll() { return dao.findAll(); }

    @Override
    public void updateEntity(T entity) { dao.update(entity); }

    @Override
    public void deleteEntity(T entity) { dao.delete(entity); }

    @Override
    public void deleteEntity(String id) { dao.delete(id); }

    @Override
    public void deleteAllEntities() { dao.deleteAll(); }

    @Override
    public void closeConnection() { dao.closeConnection(); }
}
