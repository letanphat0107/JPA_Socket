/*
 * @ (#) Course.java     1.0   4/1/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/*
 * @description:
 * @author: Le Tan Phat
 * @code: 21004661
 * @date: 4/1/2024
 * @version:  1.0
 */
@NamedQueries({
        @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c"),
        @NamedQuery(name = "Course.findByID", query = "SELECT c FROM Course c WHERE c.id = :id"),
        @NamedQuery(name = "Course.relativeSearchByTitle", query = "SELECT c FROM Course c WHERE c.title LIKE :title"),
        @NamedQuery(name = "Course.absoluteSearchByTitle", query = "SELECT c FROM Course c WHERE c.title = :title"),
        @NamedQuery(name = "Course.findByDepartmentName", query = "SELECT c FROM Course c join c.department d WHERE d.name = :name"),
        @NamedQuery(name = "Course.getCourseMaxCredits", query = "SELECT c FROM Course c WHERE c.credits = (SELECT MAX(c.credits) FROM Course c)"),
})
@Setter
@Getter
@Entity
@Table(name = "Course")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Course implements Serializable {
    private static final long serialVersionUID = 8001296845123404462L;
    @Column(name = "Credits")
    protected int credits;
    @Id
    @Column(name = "CourseID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    @Column(name = "Title")
    protected String title;

    @ManyToOne
    @JoinColumn(name = "DepartmentID")
    protected Department department;

    public Course() {
    }

    public Course(int credits, String title) {
        this.credits = credits;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Course{" +
                "credits=" + credits +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
