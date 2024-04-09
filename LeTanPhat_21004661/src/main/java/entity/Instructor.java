/*
 * @ (#) Instructor.java     1.0   4/1/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

/*
 * @description:
 * @author: Le Tan Phat
 * @code: 21004661
 * @date: 4/1/2024
 * @version:  1.0
 */
@Setter
@EqualsAndHashCode
@Getter
@NoArgsConstructor
@ToString
@Entity
public class Instructor extends Person implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "HireDate")
    private LocalDate hireDate;

    @ManyToMany
    @JoinTable(
            name = "CourseInstructor",
            joinColumns = @JoinColumn(name = "PersonID"),
            inverseJoinColumns = @JoinColumn(name = "CourseID")
    )
    private Set<Course> courses;
    public Instructor(String firstName, String lastName, LocalDate hireDate) {
        super(firstName, lastName);
        this.hireDate = hireDate;
    }
}
