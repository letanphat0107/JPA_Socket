/*
 * @ (#) CourseDao_Test.java     1.0   4/2/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

import dao.impl.CourseImpl;
import entity.Course;
import entity.OnlineCourse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

/*
 * @description:
 * @author: Le Tan Phat
 * @code: 21004661
 * @date: 4/2/2024
 * @version:  1.0
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CourseDao_Test {
    private CourseImpl courseDao;

    @BeforeAll
    public  void setUp() {
        courseDao = new CourseImpl();
    }

    @Test
    public void testAddCourse() {
        OnlineCourse onlineCourse = new OnlineCourse(3, "Java", "https://www.youtube.com/watch?v=grEKMHGYyns");
        courseDao.add(onlineCourse);
    }

    @Test
    public void testUpdateCourse() {
        OnlineCourse onlineCourse = new OnlineCourse(3, "Java", "https://www.youtube.com");
        courseDao.update(4066, onlineCourse);
    }

    @Test
    public void testDeleteCourse() {
        courseDao.delete(4066, Course.class);
    }

    @Test
    public void testFindByID() {
        Course course = courseDao.findById(4066, Course.class);
        System.out.println(course);
    }

    @Test
    public void testFindAll() {
        List<Course> courses = courseDao.findAll();
        courses.forEach(System.out::println);
    }

    @Test
    public void testRelativeSearchByTitle() {
        List<Course> courses = courseDao.relativeSearchByTitle("ph");
        courses.forEach(System.out::println);
    }

    @Test
    public void testAbsoluteSearchByTitle() {
        Course course = courseDao.absoluteSearchByTitle("Poetry");
        System.out.println(course);
    }

    @Test
    public void testFindByDepartmentName() {
        List<Course> courses = courseDao.findByDepartmentName("English");
        courses.forEach(System.out::println);
    }

    @Test
    public void testGetCourseMaxCredits() {
        List<Course> courses = courseDao.getCourseMaxCredits();
        courses.forEach(System.out::println);
    }
}
