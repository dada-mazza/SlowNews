package com.slownews.dao;

import com.slownews.entity.SlowNewsEntity;
import com.slownews.entity.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public interface DAO<E extends SlowNewsEntity> {

    EntityManager getEntityManager();

    EntityTransaction getEntityTransaction();

    void close();

    Long create(E entity);

    E getById(Class<E> entityClass, Long id);

    E update(E entity);

    void delete(E entity);

    List<E> getAll(Class<E> entityClass);
}
