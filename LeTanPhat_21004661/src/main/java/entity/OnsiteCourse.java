/*
 * @ (#) OnsiteClass.java     1.0   4/1/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/*
 * @description:
 * @author: Le Tan Phat
 * @code: 21004661
 * @date: 4/1/2024
 * @version:  1.0
 */
@Getter
@Setter
@Entity
@Table(name = "OnsiteCourse")
public class OnsiteCourse extends Course implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "Days")
    private String days;
    @Column(name = "Location")
    private String location;
    @Column(name = "Time")
    private LocalDateTime time;

    public OnsiteCourse() {
        super();
    }

public OnsiteCourse(int credits, String title, String days, String location, LocalDateTime time) {
        super(credits, title);
        this.days = days;
        this.location = location;
        this.time = time;
    }
}
