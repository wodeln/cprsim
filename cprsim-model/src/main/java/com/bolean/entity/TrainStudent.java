package com.bolean.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author 
 */
@Table(name = "cpr_train_student")
public class TrainStudent implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long train_student_id;

    private Long student_id;

    private Long train_id;

    public Long getTrain_student_id() {
        return train_student_id;
    }

    public void setTrain_student_id(Long train_student_id) {
        this.train_student_id = train_student_id;
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public Long getTrain_id() {
        return train_id;
    }

    public void setTrain_id(Long train_id) {
        this.train_id = train_id;
    }
}