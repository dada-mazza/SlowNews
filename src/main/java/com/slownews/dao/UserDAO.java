package com.slownews.dao;

import com.slownews.entity.UserEntity;

import javax.persistence.NoResultException;

public class UserDAO extends DAOImpl {

    public UserEntity getUserByLogin(String login) {
        try {
            return (UserEntity) getEntityManager()
                    .createNamedQuery("UserEntity.getUserByLogin")
                    .setParameter("login", login)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public UserEntity getUserByEmail(String email) {
        try {
            return (UserEntity) getEntityManager()
                    .createNamedQuery("UserEntity.getUserByEmail")
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
