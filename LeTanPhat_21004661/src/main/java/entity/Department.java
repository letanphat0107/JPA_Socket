/*
 * @ (#) Department.java     1.0   4/1/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.time.LocalDateTime;

/*
 * @description:
 * @author: Le Tan Phat
 * @code: 21004661
 * @date: 4/1/2024
 * @version:  1.0
 */
@Setter
@Getter
@Entity
@Table(name = "Department")
public class Department implements Serializable {
    private static final long serialVersionUID = 8001296845123404462L;
    @Column(name = "Administrator")
    private int administrator;
    @Column(name = "Budget", columnDefinition = "float")
    private double budget;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DepartmentID")
    private int id;
    @Column(name = "Name")
    private String name;
    @Column(name = "StartDate")
    private LocalDateTime startDate;


    public Department() {
    }
    public Department(int administrator, double budget, String name, LocalDateTime startDate) {
        this.administrator = administrator;
        this.budget = budget;
        this.name = name;
        this.startDate = startDate;
    }
}
