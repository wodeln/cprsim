package com.bolean.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author 
 */
@Table(name="cpr_args_score")
public class ArgsScore implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainScoreId;

    private Long argsId;

    private String argsName;

    private Integer argsScore;

    private Long userId;

    private Long projectId;

    public Long getTrainScoreId() {
        return trainScoreId;
    }

    public void setTrainScoreId(Long trainScoreId) {
        this.trainScoreId = trainScoreId;
    }

    public Long getArgsId() {
        return argsId;
    }

    public void setArgsId(Long argsId) {
        this.argsId = argsId;
    }

    public String getArgsName() {
        return argsName;
    }

    public void setArgsName(String argsName) {
        this.argsName = argsName;
    }

    public Integer getArgsScore() {
        return argsScore;
    }

    public void setArgsScore(Integer argsScore) {
        this.argsScore = argsScore;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}