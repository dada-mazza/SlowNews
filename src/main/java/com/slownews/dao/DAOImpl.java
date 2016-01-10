package com.slownews.dao;

import com.slownews.entity.SlowNewsEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class DAOImpl<E extends SlowNewsEntity> implements DAO<E> {

    private final String PERSISTENCE_UNIT_NAME = "entityManager";
    private EntityManager entityManager;

    public DAOImpl() {
        entityManager = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME)
                .createEntityManager();
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public EntityTransaction getEntityTransaction() {
        return entityManager.getTransaction();
    }

    @Override
    public void close() {
        if (entityManager != null) {
            entityManager.close();
        }
    }

    @Override
    public Long create(E entity) {
        getEntityTransaction().begin();
        getEntityManager().persist(entity);
        getEntityTransaction().commit();
        return entity.getId();
    }

    @Override
    public E getById(Class<E> entityClass, Long id) {
        return getEntityManager().find(entityClass, id);
    }

    @Override
    public E update(E entity) {
        getEntityTransaction().begin();
        getEntityManager().merge(entity);
        getEntityTransaction().commit();
        return entity;
    }

    @Override
    public void delete(E entity) {
        getEntityTransaction().begin();
        getEntityManager().remove(entity);
        getEntityTransaction().commit();
    }

    @Override
    public List<E> getAll(Class<E> entityClass) {
        TypedQuery<E> namedQuery = getEntityManager()
                .createNamedQuery(entityClass.getSimpleName() + ".getAll", entityClass);
        return namedQuery.getResultList();
    }

}
