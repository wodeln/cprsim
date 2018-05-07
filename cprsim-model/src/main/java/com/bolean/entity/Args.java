package com.bolean.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author 
 */
@Table(name="cpr_args")
public class Args implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long argsId;

    /**
     * 参数名称
     */
    @NotEmpty
    private String argsName;

    /**
     * 参数分类ID
     */
    @NotEmpty
    private Long argsTypeId;

    /**
     * 评分
     */
    @NotEmpty
    private Integer argsPoint;

    private String argsKey;

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

    public Long getArgsTypeId() {
        return argsTypeId;
    }

    public void setArgsTypeId(Long argsTypeId) {
        this.argsTypeId = argsTypeId;
    }

    public Integer getArgsPoint() {
        return argsPoint;
    }

    public void setArgsPoint(Integer argsPoint) {
        this.argsPoint = argsPoint;
    }

    public String getArgsKey() {
        return argsKey;
    }

    public void setArgsKey(String argsKey) {
        this.argsKey = argsKey;
    }
}