/*
 * @ (#) OfficeAssignment.java     1.0   4/1/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

/*
 * @description:
 * @author: Le Tan Phat
 * @code: 21004661
 * @date: 4/1/2024
 * @version:  1.0
 */
@NoArgsConstructor
@lombok.Data
@Entity
@Table(name = "OfficeAssignment")
public class OfficeAssignment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "Location")
    private String location;
    @Column(name = "Timestamp")
    private Timestamp timestamp;
    @OneToOne
    @Id
    @JoinColumn(name = "InstructorID")
    private Instructor instructorID;
}
