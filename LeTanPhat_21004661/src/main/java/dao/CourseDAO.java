/*
 * @ (#) CourseDAO.java     1.0   4/8/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package dao;

import entity.Course;

import java.util.List;

/*
 * @description:
 * @author: Le Tan Phat
 * @code: 21004661
 * @date: 4/8/2024
 * @version:  1.0
 */
public interface CourseDAO{
    public List<Course> findAll();
    public List<Course> relativeSearchByTitle(String title);
    public Course absoluteSearchByTitle(String title);
    public List<Course> findByDepartmentName(String name);
    public List<Course> getCourseMaxCredits();
}
