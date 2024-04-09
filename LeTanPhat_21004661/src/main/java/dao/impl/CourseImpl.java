/*
 * @ (#) CourseDao.java     1.0   4/1/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package dao.impl;

import dao.GenericDAO;
import dao.CourseDAO;
import entity.Course;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

/*
 * @description:
 * @author: Le Tan Phat
 * @code: 21004661
 * @date: 4/1/2024
 * @version:  1.0
 */
public class CourseImpl extends GenericDAO<Course> implements CourseDAO{
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_SQL");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();

    @Override
    public List<Course> findAll() {
        return em.createQuery("SELECT c FROM Course c", Course.class).getResultList();
    }

    @Override
    public List<Course> relativeSearchByTitle(String title) {
        return em.createNamedQuery("Course.relativeSearchByTitle", Course.class)
                .setParameter("title", "%" +title+ "%")
                .getResultList();
    }

    @Override
    public Course absoluteSearchByTitle(String title) {
        return em.createNamedQuery("Course.absoluteSearchByTitle", Course.class)
                .setParameter("title", title)
                .getResultList()
                .stream()
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Course> findByDepartmentName(String name) {
        return em.createNamedQuery("Course.findByDepartmentName", Course.class)
                .setParameter("name", name)
                .getResultList();
    }

    @Override
    public List<Course> getCourseMaxCredits() {
        return em.createNamedQuery("Course.getCourseMaxCredits", Course.class).getResultList();
    }

    public void close() {
        em.close();
        emf.close();
    }

}
