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

    @Transient
    private String studentName;

    @Transient
    private Integer studentSex;

    @Transient
    private String studentDegree;

    @Transient
    private String studentCardNo;

    @Transient
    private String studentCompany;

    @Transient
    private String studentHomeAddress;

    @Transient
    private String studentEmail;

    @Transient
    private String studentPhone;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

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

    public Integer getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(Integer studentSex) {
        this.studentSex = studentSex;
    }

    public String getStudentDegree() {
        return studentDegree;
    }

    public void setStudentDegree(String studentDegree) {
        this.studentDegree = studentDegree;
    }

    public String getStudentCardNo() {
        return studentCardNo;
    }

    public void setStudentCardNo(String studentCardNo) {
        this.studentCardNo = studentCardNo;
    }

    public String getStudentCompany() {
        return studentCompany;
    }

    public void setStudentCompany(String studentCompany) {
        this.studentCompany = studentCompany;
    }

    public String getStudentHomeAddress() {
        return studentHomeAddress;
    }

    public void setStudentHomeAddress(String studentHomeAddress) {
        this.studentHomeAddress = studentHomeAddress;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }
}