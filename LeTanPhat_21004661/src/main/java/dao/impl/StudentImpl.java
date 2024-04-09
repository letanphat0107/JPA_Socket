/*
 * @ (#) StudentImpl.java     1.0   4/8/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package dao.impl;

import dao.GenericDAO;
import dao.StudentDAO;
import entity.Student;

import java.util.List;

/*
 * @description:
 * @author: Le Tan Phat
 * @code: 21004661
 * @date: 4/8/2024
 * @version:  1.0
 */
public class StudentImpl extends GenericDAO<Student> implements StudentDAO {
    @Override
    public List<Student> findAll() {
        return em.createNamedQuery("Student.findAll", Student.class).getResultList();
    }

    @Override
    public List<Student> findStudentsEnrolledInCourse(String title) {
        return null;
    }

    @Override
    public List<Student> findStudentsEnrolledInYear(int year) {
        return em.createNamedQuery("Student.findStudentsEnrolledInYear", Student.class)
                .setParameter("year", year)
                .getResultList();
    }
}
