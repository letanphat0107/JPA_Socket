/*
 * @ (#) OnlineCourse.java     1.0   4/1/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/*
 * @description:
 * @author: Le Tan Phat
 * @code: 21004661
 * @date: 4/1/2024
 * @version:  1.0
 */
@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Table(name = "OnlineCourse")
public class OnlineCourse extends Course implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "URL")
    private String url;


    public OnlineCourse() {
        super();
    }
    public OnlineCourse(int credits, String title, String url) {
        super(credits, title);
        this.url = url;
    }

}
