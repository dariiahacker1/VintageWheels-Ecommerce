package org.application.wheels.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.application.wheels.utils.SessionFactoryUtil;
import java.util.List;

public abstract class AbstractDao<T> implements Dao<T> {
    private final Session session;
    private final Transaction transaction;
    private final Class<T> entityClass;

    protected AbstractDao(Class<T> entityClass) {
        this.session =  SessionFactoryUtil.getSessionFactory().openSession();

        this.transaction = session.beginTransaction();

        this.entityClass = entityClass;
    }

    public void save(T t) { session.persist(t); }

    public T getById(String id) { return session.get(entityClass, id); }

    public List<T> findAll() {
        String simpleClassName = entityClass.getSimpleName();

        return session.createQuery("from " + simpleClassName, entityClass)
                .list();
    }

    public void update(T t) { session.merge(t); }

    public void delete(T t) { session.remove(t); }

    public void delete(String id) { delete(getById(id)); }

    public void deleteAll() {
        List<T> entities = findAll();

        for (T entity : entities)
            delete(entity);
    }

    public void closeConnection() {
        transaction.commit();

        session.close();
    }
}
