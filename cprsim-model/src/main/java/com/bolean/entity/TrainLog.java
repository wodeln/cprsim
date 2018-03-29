package com.bolean.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author 
 */
@Table(name="cpr_train_log")
public class TrainLog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer trainLogId;

    /**
     * 练考ID
     */
    @NotEmpty
    private Integer trainId;

    /**
     * 培训项目ID
     */
    @NotEmpty
    private Integer examId;

    /**
     * 用户ID
     */
    @NotEmpty
    private Integer userId;

    /**
     * 得分
     */
    @NotEmpty
    private Float trainPoint;

    /**
     * 是否及格 0:未及格 1:及格
     */
    @NotEmpty
    private Boolean ifPass;

    private static final long serialVersionUID = 1L;

    public Integer getTrainLogId() {
        return trainLogId;
    }

    public void setTrainLogId(Integer trainLogId) {
        this.trainLogId = trainLogId;
    }

    public Integer getTrainId() {
        return trainId;
    }

    public void setTrainId(Integer trainId) {
        this.trainId = trainId;
    }

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Float getTrainPoint() {
        return trainPoint;
    }

    public void setTrainPoint(Float trainPoint) {
        this.trainPoint = trainPoint;
    }

    public Boolean getIfPass() {
        return ifPass;
    }

    public void setIfPass(Boolean ifPass) {
        this.ifPass = ifPass;
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
        TrainLog other = (TrainLog) that;
        return (this.getTrainLogId() == null ? other.getTrainLogId() == null : this.getTrainLogId().equals(other.getTrainLogId()))
            && (this.getTrainId() == null ? other.getTrainId() == null : this.getTrainId().equals(other.getTrainId()))
            && (this.getExamId() == null ? other.getExamId() == null : this.getExamId().equals(other.getExamId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getTrainPoint() == null ? other.getTrainPoint() == null : this.getTrainPoint().equals(other.getTrainPoint()))
            && (this.getIfPass() == null ? other.getIfPass() == null : this.getIfPass().equals(other.getIfPass()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTrainLogId() == null) ? 0 : getTrainLogId().hashCode());
        result = prime * result + ((getTrainId() == null) ? 0 : getTrainId().hashCode());
        result = prime * result + ((getExamId() == null) ? 0 : getExamId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getTrainPoint() == null) ? 0 : getTrainPoint().hashCode());
        result = prime * result + ((getIfPass() == null) ? 0 : getIfPass().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", trainLogId=").append(trainLogId);
        sb.append(", trainId=").append(trainId);
        sb.append(", examId=").append(examId);
        sb.append(", userId=").append(userId);
        sb.append(", trainPoint=").append(trainPoint);
        sb.append(", ifPass=").append(ifPass);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}