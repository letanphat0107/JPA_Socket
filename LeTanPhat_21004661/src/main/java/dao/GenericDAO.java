/*
 * @ (#) GenericDAO.java     1.0   4/8/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package dao;

import entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/*
 * @description:
 * @author: Le Tan Phat
 * @code: 21004661
 * @date: 4/8/2024
 * @version:  1.0
 */
public abstract class GenericDAO<T> {
    protected EntityManager em;

    public GenericDAO() {
        em = Persistence.createEntityManagerFactory("JPA_SQL")
                .createEntityManager();
    }

    public boolean add(T t){
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            em.persist(t);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id, Class<T> clazz){
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            T entity = em.find(clazz, id);
            if (entity == null) {
                return false;
            }
            em.remove(entity);
            tx.commit();
            return true;
        }catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(int id,T t){
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            T existingEntity = (T) em.find(t.getClass(), id);
            if (existingEntity == null) {
                return false;
            }
            existingEntity = em.merge(t);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public T findById(int id, Class<T> clazz) {
        return em.find(clazz, id);
    }

    public void close() {
        em.close();
    }
}
