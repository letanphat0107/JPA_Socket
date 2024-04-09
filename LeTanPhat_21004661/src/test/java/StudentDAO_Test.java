/*
 * @ (#) StudentDAO_Test.java     1.0   4/8/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

import dao.impl.StudentImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

/*
 * @description:
 * @author: Le Tan Phat
 * @code: 21004661
 * @date: 4/8/2024
 * @version:  1.0
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StudentDAO_Test {
    private StudentImpl studentDao;

    @BeforeAll
    public void setUp() {
        studentDao = new StudentImpl();
    }

    @Test
    public void testFindAll() {
        studentDao.findAll().forEach(System.out::println);
    }

    @Test
    public void testFindStudentsEnrolledInYear() {
        studentDao.findStudentsEnrolledInYear(2005).forEach(System.out::println);
    }
}
