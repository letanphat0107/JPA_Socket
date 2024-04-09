/*
 * @ (#) Student.java     1.0   4/1/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

import java.io.Serializable;
import java.time.LocalDateTime;/*
 * @description:
 * @author: Le Tan Phat
 * @code: 21004661
 * @date: 4/1/2024
 * @version:  1.0
 */
@NamedQueries({
        @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
        @NamedQuery(name = "Student.findStudentsEnrolledInYear", query = "SELECT s FROM Student s WHERE year(s.enrollmentDate) = :year")
})
@Entity
public class Student extends Person implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "EnrollmentDate")
    private LocalDateTime enrollmentDate;

    public Student(LocalDateTime enrollmentDate, String firstName, String lastName) {
        super(firstName, lastName);
        this.enrollmentDate = enrollmentDate;
    }
    @Override
    public String toString() {
        return "Student{" +
                "enrollmentDate=" + enrollmentDate +
                ", firstName='" + firstName + '\'' +
                ", id=" + id +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
