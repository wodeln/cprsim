package com.bolean.entity;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author 
 */
@Table(name="cpr_exam")
public class Exam implements Serializable {
    /**
     * 练考计划自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long examId;

    /**
     * 练考计划名称
     */
    @NotEmpty
    private String examName;

    /**
     * 培训类别 1:考试 2:练习
     */
    @NotEmpty
    private Boolean examType;

    /**
     * 培训时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date examTime;

    /**
     * 培训时长 (分钟)
     */
    private Integer examMinutes;

    /**
     * 培训地点
     */
    private String examPlace;

    /**
     * 练考计划状态 0:关闭 1:激活
     */
    @NotEmpty
    private Boolean examStatus;

    private String examKind;

    private String examTarget;

    @Transient
    private List<Train> trains;

    @Transient
    private Integer studentCount;

    private static final long serialVersionUID = 1L;

    public List<Train> getTrains() {
        return trains;
    }

    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }

    public String getExamTarget() {
        return examTarget;
    }

    public void setExamTarget(String examTarget) {
        this.examTarget = examTarget;
    }

    public String getExamKind() {
        return examKind;
    }

    public void setExamKind(String examKind) {
        this.examKind = examKind;
    }

    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public Boolean getExamType() {
        return examType;
    }

    public void setExamType(Boolean examType) {
        this.examType = examType;
    }

    public Date getExamTime() {
        return examTime;
    }

    public void setExamTime(Date examTime) {
        this.examTime = examTime;
    }

    public Integer getExamMinutes() {
        return examMinutes;
    }

    public void setExamMinutes(Integer examMinutes) {
        this.examMinutes = examMinutes;
    }

    public String getExamPlace() {
        return examPlace;
    }

    public void setExamPlace(String examPlace) {
        this.examPlace = examPlace;
    }

    public Boolean getExamStatus() {
        return examStatus;
    }

    public void setExamStatus(Boolean examStatus) {
        this.examStatus = examStatus;
    }

    public Integer getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(Integer studentCount) {
        this.studentCount = studentCount;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Exam other = (Exam) that;
        return (this.getExamId() == null ? other.getExamId() == null : this.getExamId().equals(other.getExamId()))
            && (this.getExamName() == null ? other.getExamName() == null : this.getExamName().equals(other.getExamName()))
            && (this.getExamType() == null ? other.getExamType() == null : this.getExamType().equals(other.getExamType()))
            && (this.getExamTime() == null ? other.getExamTime() == null : this.getExamTime().equals(other.getExamTime()))
            && (this.getExamMinutes() == null ? other.getExamMinutes() == null : this.getExamMinutes().equals(other.getExamMinutes()))
            && (this.getExamPlace() == null ? other.getExamPlace() == null : this.getExamPlace().equals(other.getExamPlace()))
            && (this.getExamStatus() == null ? other.getExamStatus() == null : this.getExamStatus().equals(other.getExamStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getExamId() == null) ? 0 : getExamId().hashCode());
        result = prime * result + ((getExamName() == null) ? 0 : getExamName().hashCode());
        result = prime * result + ((getExamType() == null) ? 0 : getExamType().hashCode());
        result = prime * result + ((getExamTime() == null) ? 0 : getExamTime().hashCode());
        result = prime * result + ((getExamMinutes() == null) ? 0 : getExamMinutes().hashCode());
        result = prime * result + ((getExamPlace() == null) ? 0 : getExamPlace().hashCode());
        result = prime * result + ((getExamStatus() == null) ? 0 : getExamStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", examId=").append(examId);
        sb.append(", examName=").append(examName);
        sb.append(", examType=").append(examType);
        sb.append(", examTime=").append(examTime);
        sb.append(", examMinutes=").append(examMinutes);
        sb.append(", examPlace=").append(examPlace);
        sb.append(", examStatus=").append(examStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}