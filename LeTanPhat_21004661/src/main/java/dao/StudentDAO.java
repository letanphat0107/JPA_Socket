/*
 * @ (#) StudentDAO.java     1.0   4/8/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package dao;

import entity.Student;

import java.util.List;

/*
 * @description:
 * @author: Le Tan Phat
 * @code: 21004661
 * @date: 4/8/2024
 * @version:  1.0
 */
public interface StudentDAO {
    public List<Student> findAll();
    public List<Student> findStudentsEnrolledInCourse(String title);
    public List<Student> findStudentsEnrolledInYear(int year);
}
