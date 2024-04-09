/*
 * @ (#) StudentGrade.java     1.0   4/1/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package entity;

/*
 * @description:
 * @author: Le Tan Phat
 * @code: 21004661
 * @date: 4/1/2024
 * @version:  1.0
 */

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "StudentGrade")
public class StudentGrade implements Serializable {
    private static final long serialVersionUID = 1L;
    @ManyToOne
    @JoinColumn(name = "CourseID")
    private Course course;

    @Id
    @Column(name = "enrollmentID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int enrollmentID;

    @Column(name = "Grade")
    private double grade;

    @ManyToOne
    @JoinColumn(name = "StudentID")
    private Student student;

public StudentGrade(Course course, double grade, Student student) {
        this.course = course;
        this.grade = grade;
        this.student = student;
    }
}
