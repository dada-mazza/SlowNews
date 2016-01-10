package com.slownews.dao;

import com.slownews.entity.ArchiveNewsEntity;

import javax.persistence.NoResultException;
import java.util.List;


public class ArchiveNewsDao extends DAOImpl {

    public ArchiveNewsEntity getArchiveNewsEntityByTitle(String title) {
        try {
            return (ArchiveNewsEntity) getEntityManager()
                    .createNamedQuery("ArchiveNewsEntity.getArchiveNewsEntityByTitle")
                    .setParameter("title", title)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<ArchiveNewsEntity> getAllArchiveNewsesForUser(Long userId) {
        try {
            return (List<ArchiveNewsEntity>) getEntityManager()
                    .createNamedQuery("ArchiveNewsEntity.getAllArchiveNewsesForUser")
                    .setParameter("userId", userId)
                    .getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

}
