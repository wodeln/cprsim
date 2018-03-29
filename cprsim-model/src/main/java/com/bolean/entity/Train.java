package com.bolean.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author 
 */
@Table(name="cpr_train")
public class Train implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer trainId;

    /**
     * 培训项目名称
     */
    @NotEmpty
    private String trainName;

    /**
     * 培训对象
     */
    private String trainContent;

    /**
     * 培训目标
     */
    private String trainTarget;

    /**
     * 培训开始时间
     */
    @NotEmpty
    private Date trainBeginTime;

    /**
     * 培训持续时间(天数)
     */
    private Integer trainDays;

    /**
     * 培训地点
     */
    private String trainPlace;

    /**
     * 培训项目状态 0:关闭 1:开启
     */
    private Boolean trainStatus;

    /**
     * 所属培训项目ID
     */
    private Integer examId;

    private static final long serialVersionUID = 1L;

    public Integer getTrainId() {
        return trainId;
    }

    public void setTrainId(Integer trainId) {
        this.trainId = trainId;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getTrainContent() {
        return trainContent;
    }

    public void setTrainContent(String trainContent) {
        this.trainContent = trainContent;
    }

    public String getTrainTarget() {
        return trainTarget;
    }

    public void setTrainTarget(String trainTarget) {
        this.trainTarget = trainTarget;
    }

    public Date getTrainBeginTime() {
        return trainBeginTime;
    }

    public void setTrainBeginTime(Date trainBeginTime) {
        this.trainBeginTime = trainBeginTime;
    }

    public Integer getTrainDays() {
        return trainDays;
    }

    public void setTrainDays(Integer trainDays) {
        this.trainDays = trainDays;
    }

    public String getTrainPlace() {
        return trainPlace;
    }

    public void setTrainPlace(String trainPlace) {
        this.trainPlace = trainPlace;
    }

    public Boolean getTrainStatus() {
        return trainStatus;
    }

    public void setTrainStatus(Boolean trainStatus) {
        this.trainStatus = trainStatus;
    }

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
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
        Train other = (Train) that;
        return (this.getTrainId() == null ? other.getTrainId() == null : this.getTrainId().equals(other.getTrainId()))
            && (this.getTrainName() == null ? other.getTrainName() == null : this.getTrainName().equals(other.getTrainName()))
            && (this.getTrainContent() == null ? other.getTrainContent() == null : this.getTrainContent().equals(other.getTrainContent()))
            && (this.getTrainTarget() == null ? other.getTrainTarget() == null : this.getTrainTarget().equals(other.getTrainTarget()))
            && (this.getTrainBeginTime() == null ? other.getTrainBeginTime() == null : this.getTrainBeginTime().equals(other.getTrainBeginTime()))
            && (this.getTrainDays() == null ? other.getTrainDays() == null : this.getTrainDays().equals(other.getTrainDays()))
            && (this.getTrainPlace() == null ? other.getTrainPlace() == null : this.getTrainPlace().equals(other.getTrainPlace()))
            && (this.getTrainStatus() == null ? other.getTrainStatus() == null : this.getTrainStatus().equals(other.getTrainStatus()))
            && (this.getExamId() == null ? other.getExamId() == null : this.getExamId().equals(other.getExamId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTrainId() == null) ? 0 : getTrainId().hashCode());
        result = prime * result + ((getTrainName() == null) ? 0 : getTrainName().hashCode());
        result = prime * result + ((getTrainContent() == null) ? 0 : getTrainContent().hashCode());
        result = prime * result + ((getTrainTarget() == null) ? 0 : getTrainTarget().hashCode());
        result = prime * result + ((getTrainBeginTime() == null) ? 0 : getTrainBeginTime().hashCode());
        result = prime * result + ((getTrainDays() == null) ? 0 : getTrainDays().hashCode());
        result = prime * result + ((getTrainPlace() == null) ? 0 : getTrainPlace().hashCode());
        result = prime * result + ((getTrainStatus() == null) ? 0 : getTrainStatus().hashCode());
        result = prime * result + ((getExamId() == null) ? 0 : getExamId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", trainId=").append(trainId);
        sb.append(", trainName=").append(trainName);
        sb.append(", trainContent=").append(trainContent);
        sb.append(", trainTarget=").append(trainTarget);
        sb.append(", trainBeginTime=").append(trainBeginTime);
        sb.append(", trainDays=").append(trainDays);
        sb.append(", trainPlace=").append(trainPlace);
        sb.append(", trainStatus=").append(trainStatus);
        sb.append(", examId=").append(examId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}